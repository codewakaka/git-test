package com.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听规则
 *
 * @author cmy
 * @date ：Created on 2019/12/26
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void  check (ApiStateInfo apiStateInfo){
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStateInfo);
        }
    }
}
