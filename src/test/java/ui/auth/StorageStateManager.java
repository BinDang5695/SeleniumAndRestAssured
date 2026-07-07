package ui.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import settings.drivers.DriverManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StorageStateManager {

    private static final ObjectMapper mapper = new ObjectMapper();

    // ================= SAVE =================
    public static void save(String file) {

        try {
            WebDriver driver = DriverManager.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            Path path = Path.of(file);
            Files.createDirectories(path.getParent());

            // cookies
            Set<Cookie> cookies = driver.manage().getCookies();

            List<CookieDTO> cookieDTOs = cookies.stream().map(c -> {
                CookieDTO d = new CookieDTO();
                d.name = c.getName();
                d.value = c.getValue();
                d.domain = c.getDomain();
                d.path = c.getPath();
                d.secure = c.isSecure();
                d.httpOnly = c.isHttpOnly();
                d.expiry = c.getExpiry() != null ? c.getExpiry().getTime() : null;
                d.sameSite = c.getSameSite();
                return d;
            }).toList();

            // localStorage
            Map<String, String> localStorage =
                    (Map<String, String>) js.executeScript(
                            "let items = {}; " +
                                    "for (let i = 0; i < localStorage.length; i++) {" +
                                    "let k = localStorage.key(i); items[k] = localStorage.getItem(k); } return items;"
                    );

            // sessionStorage
            Map<String, String> sessionStorage =
                    (Map<String, String>) js.executeScript(
                            "let items = {}; " +
                                    "for (let i = 0; i < sessionStorage.length; i++) {" +
                                    "let k = sessionStorage.key(i); items[k] = sessionStorage.getItem(k); } return items;"
                    );

            StorageState state = new StorageState();
            state.cookies = cookieDTOs;
            state.localStorage = localStorage;
            state.sessionStorage = sessionStorage;

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(path.toFile(), state);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ================= RESTORE =================
    public static boolean restore(String baseUrl, String file) {

        try {
            Path path = Path.of(file);
            if (!Files.exists(path)) return false;

            WebDriver driver = DriverManager.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.get(baseUrl);

            StorageState state =
                    mapper.readValue(path.toFile(), StorageState.class);

            // cookies
            for (CookieDTO c : state.cookies) {

                Cookie cookie = new Cookie.Builder(c.name, c.value)
                        .domain(c.domain)
                        .path(c.path)
                        .isSecure(c.secure)
                        .isHttpOnly(c.httpOnly)
                        .build();

                driver.manage().addCookie(cookie);
            }

            driver.navigate().refresh();

            // localStorage restore
            if (state.localStorage != null) {
                for (Map.Entry<String, String> entry : state.localStorage.entrySet()) {
                    js.executeScript(
                            "window.localStorage.setItem(arguments[0], arguments[1]);",
                            entry.getKey(),
                            entry.getValue()
                    );
                }
            }

            // sessionStorage restore
            if (state.sessionStorage != null) {
                for (Map.Entry<String, String> entry : state.sessionStorage.entrySet()) {
                    js.executeScript(
                            "window.sessionStorage.setItem(arguments[0], arguments[1]);",
                            entry.getKey(),
                            entry.getValue()
                    );
                }
            }

            driver.navigate().refresh();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}