package com.netty.serIializable.msgpack;

import lombok.Data;

/**
 * @ClassName User
 * @Description:
 * @Author xgh
 * @Date 2021/4/11
 **/
@Data
public class User {
    private String id;
    private String username;
    private int age;

    private UserContact userContact;
}
