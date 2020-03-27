package com.token;

/**
 * @author cmy
 * @date ：Created on 2019/12/24
 */
public class ApiTest {

    public static void main(String[] args) {
        ApiAuthencator apiAuthencator = new DefaultApiAufthencatorImpl();
        String url = "http://192.168.0.1:80/aa?appId=1001&timestamp="+System.currentTimeMillis()+"&token=/LkfQHYV6vPBXO4XF0cptbkb7jw=";
        apiAuthencator.auth(url);
    }
}
