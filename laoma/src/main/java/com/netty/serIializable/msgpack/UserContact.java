package com.netty.serIializable.msgpack;

import lombok.Data;

/**
 * @ClassName UserContact
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
@Data
public class UserContact {

    private String mail;
    private String phone;

    public UserContact(String mail, String phone) {
        this.mail = mail;
        this.phone = phone;
    }
}
