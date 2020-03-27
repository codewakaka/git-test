package com.ocp;

import javax.management.Notification;

/**
 * @author cmy
 * @date ：Created on 2019/12/26
 */
public abstract class AlertHandler {
    protected  AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStateInfo apiStateInfo);
}
