package com.token;

/**
 * @author cmy
 * @date ：Created on 2019/12/24
 */
public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl,String appId,String token,long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest careteFromFullUrl(String url){
        //http://192.168.0.1:80/aa?appId=1001&timestamp=1307788865&token=a78cdef998
        String [] reqArray = url.split("&");
        String baseUrl = reqArray[0].split("\\?", 2)[0];
        String appId = reqArray[0].split("=",2)[1];
        long timestamp = Long.parseLong(reqArray[1].split("=", 2)[1]);
        String token = reqArray[2].split("=", 2)[1];
        return new ApiRequest(baseUrl, appId, token, timestamp);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
