package com.ocp;

/**
 * api状态信息
 *
 * @author cmy
 * @date ：Created on 2019/12/26
 */
public class ApiStateInfo {

    private String api;
    private long requertCount;
    private long errorCount;
    private long durationOfSeconds;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequertCount() {
        return requertCount;
    }

    public void setRequertCount(long requertCount) {
        this.requertCount = requertCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public void setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
    }
}
