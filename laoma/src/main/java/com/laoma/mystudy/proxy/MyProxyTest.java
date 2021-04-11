package com.laoma.mystudy.proxy;

import java.lang.reflect.Proxy;

/**
 * @author xgh
 * @date ：Created on 2020/12/4
 */
public class MyProxyTest {

    public static void main(String[] args) {
        MyDao o = (MyDao)Proxy.newProxyInstance(MyProxyTest.class.getClassLoader(), new Class[]{MyDao.class}, new MyHandler(new MyDaoImpe()));
       o.query();

       /* byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "$proxy19", new Class[]{MyDao.class}, 22);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\$proxy19.class");
            fileOutputStream.write(proxyClassFile);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
