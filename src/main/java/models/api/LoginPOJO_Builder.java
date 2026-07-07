package models.api;

import settings.globals.ConfigsGlobal;
import models.LoginPOJO;

public class LoginPOJO_Builder {

    public static LoginPOJO getDataLogin(){
        return LoginPOJO.builder()
                .username(ConfigsGlobal.USERNAME)
                .password(ConfigsGlobal.PASSWORD)
                .build();
    }

}