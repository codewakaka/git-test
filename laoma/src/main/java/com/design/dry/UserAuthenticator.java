package com.design.dry;


import org.apache.commons.lang.StringUtils;

public class UserAuthenticator {

    public void authenticate(String userName, String password) {

    }

    public boolean isValisUserName(String userName) {
        //check not null or empty
        if (StringUtils.isBlank(userName)) {
            return false;
        }
        //check 4 -64
        int length = userName.length();
        if (length < 4 || length > 64) {
            return false;
        }
        //only lowCase
        if (!StringUtils.isAllLowerCase(userName)) {
            return false;
        }
        //check 0-9 a-z
        for (int i = 0; i < length; i++) {
            char c = userName.charAt(i);
            if ((c >= '0' && c <= '9') || !(c >= 'a' && c <= 'z') || c == '.') {
                return false;
            }
        }
        return true;
    }
}
