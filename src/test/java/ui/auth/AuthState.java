package ui.auth;

import java.util.List;

public class AuthState {

    public List<CookieDTO> cookies;

    public AuthState() {}

    public AuthState(List<CookieDTO> cookies) {
        this.cookies = cookies;
    }
}