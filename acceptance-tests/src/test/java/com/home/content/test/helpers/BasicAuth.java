package com.home.content.test.helpers;




import com.amazonaws.util.Base64;

import static java.lang.String.format;



public class BasicAuth {

    public static final String AUTH_HEADER = "Authorization";

    public static String basicAuth(final String username, final String password) {
        return "Basic " + new String(Base64.encode(format("%s:%s", username, password).getBytes()));
    }
}
