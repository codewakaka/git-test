package com.ocp;

import javax.management.Notification;

/**
 * @author cmy
 * @date ：Created on 2019/12/26
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStateInfo apiStateInfo) {
        long tps = apiStateInfo.getRequertCount()/apiStateInfo.getDurationOfSeconds();

    }
}
