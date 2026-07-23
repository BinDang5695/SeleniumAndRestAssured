package testdata.api;

import settings.globals.ConfigsGlobal;

public class Login {

    public static models.api.Login getDataLogin(){
        return models.api.Login.builder()
                .username(ConfigsGlobal.USERNAME)
                .password(ConfigsGlobal.PASSWORD)
                .build();
    }

}