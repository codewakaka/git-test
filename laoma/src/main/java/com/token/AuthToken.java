package com.token;

import javax.naming.ldap.PagedResultsControl;
import java.util.Base64;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author cmy
 * @date ：Created on 2019/12/24
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;
    private static final String SEPARATE = "@";

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
       // String token =
        return  null;
    }

    public  AuthToken generate(String originalUrl, String appId, String password, long timestamp) {
        String token = generateTokenString(originalUrl, appId, timestamp, password);
        AuthToken authToken = new AuthToken(token, timestamp);
        return authToken;
    }

    public static String generateTokenString(String originalUrl, String appId, long timestamp, String password) {
        //http://192.168.0.1:80/aa?appId=1001&token=a78cdef998
        StringBuffer sb = new StringBuffer(originalUrl);
        sb.append("?appId=").append(appId);
        sb.append("&password=").append(password);
        return hmacSha1(sb.toString(),password);
    }

    public static String hmacSha1(String value, String key) {
        try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            byte[] result = Base64.getEncoder().encode(rawHmac);

            //  Covert array of Hex bytes to a String
            return new String(result, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //http://192.168.0.1:80/aa?appId=1001&password=123456
        System.out.println(hmacSha1("http://192.168.0.1:80/aa?appId=1001&password=123456","123456"));
    }
    public String getToken() {
        return this.token;
    }

    public boolean isExpired() {
        return this.createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean mathch(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }
}
