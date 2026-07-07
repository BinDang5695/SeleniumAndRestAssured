package settings.helpers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import settings.utils.LogUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    public static void verifyAndCleanDownloadedFile(String dirPath, String fileName) {
        File file = new File(dirPath + File.separator + fileName);

        int waitTime = 0;
        while (!file.exists() && waitTime < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitTime++;
        }

        Assert.assertTrue(file.exists(), "❌ File not downloaded yet: " + fileName);
        Assert.assertTrue(file.length() > 0, "❌ File downloaded is empty: " + fileName);

        LogUtils.info("✅ File downloaded: " + fileName + " (" + file.length() + " bytes)");

        if (file.delete()) {
            LogUtils.info("🧹 Delete file after cheking: " + fileName);
        } else {
            LogUtils.info("⚠️ Can not delete file: " + fileName);
        }
    }

    public static String readPdfText(String filePath) {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            document.close();
            return text;
        } catch (Exception e) {
            throw new RuntimeException("Error reading PDF file: " + filePath, e);
        }
    }

    public static String readCsvText(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }
    }

    public static String readExcelAsText(String filePath) {

        StringBuilder builder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            DataFormatter formatter = new DataFormatter();

            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        builder.append(formatter.formatCellValue(cell)).append(" ");
                    }
                    builder.append(System.lineSeparator());
                }
            }

            return builder.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + filePath, e);
        }
    }

    public static void waitForFileExists(String fullPath, int timeout) {
        File file = new File(fullPath);

        for (int i = 0; i < timeout; i++) {
            if (file.exists()) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {}
        }

        Assert.fail("❌ File not found: " + fullPath);
    }

    public static void deleteFile(String fullPath) {
        File f = new File(fullPath);
        if (f.exists()) {
            f.delete();
            LogUtils.info("🧹 Deleted file: " + fullPath);
        }
    }

    public static String getTestDataFile(String fileName) {
        return Paths.get(
                System.getProperty("user.dir"),
                "src",
                "test",
                "resources",
                "testdata",
                fileName
        ).toString();
    }


}
