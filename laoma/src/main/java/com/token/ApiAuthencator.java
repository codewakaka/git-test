package com.token;

/**
 * @author cmy
 * @date ：Created on 2019/12/24
 */
public interface ApiAuthencator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
