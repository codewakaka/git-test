package com.token;

/**
 * @author cmy
 * @date ：Created on 2019/12/24
 */
public class DefaultApiAufthencatorImpl implements ApiAuthencator {
    private CredentialStorage credentialStorage;

    public DefaultApiAufthencatorImpl() {
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAufthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.careteFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getBaseUrl();
        AuthToken clicentAuthToke = new AuthToken(token, timestamp);
        if (clicentAuthToke.isExpired()) {
            throw new RuntimeException("token is expired.");
        }
        String password = credentialStorage.getPassWordByAppId(appId);
        AuthToken generate = clicentAuthToke.generate(originalUrl, appId, password, timestamp);
        if (!generate.mathch(clicentAuthToke)) {
            throw new RuntimeException("token verficate failed");
        }
        System.out.println("success");
    }
}
