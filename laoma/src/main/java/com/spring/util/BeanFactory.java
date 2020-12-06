package com.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author xgh
 * @date ：Created on 2020/12/6
 */
public class BeanFactory {
    Map<String, Object> map = new HashMap<>();


    public BeanFactory(String xml) {
        processXml(xml);
    }

    private void processXml(String xml) {
        File file = new File(this.getClass().getResource("/").getPath() + "//" + xml);
        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(file);
            Element elementRoot = document.getRootElement();
            boolean flage = false;
            Attribute attribute = elementRoot.attribute("default-autowire");
            if (attribute != null) {
                flage = true;
            }


            for (Iterator<Element> itFirlst = elementRoot.elementIterator(); itFirlst.hasNext(); ) {
                //遍历所有的bean 一级子标题
                Element el = itFirlst.next();
                Attribute calssId = el.attribute("id");
                String calssIdValue = calssId.getValue();
                Attribute className = el.attribute("class");
                String classNameValue = className.getValue();
                Class<?> aClass = Class.forName(classNameValue);
                //是否自动装配


                Object regisetObject = null;
                //遍历所有的二级，判断是setter注入，还是构造方法注入
                for (Iterator<Element> j = el.elementIterator(); j.hasNext(); ) {
                    Element elementSecend = j.next();
                    if (elementSecend.getName().equals("property")) {

                        //setter注入
                        Attribute name = elementSecend.attribute("name");
                        String nameValue = name.getValue();
                        Attribute ref = elementSecend.attribute("ref");
                        String refValue = ref.getValue();
                        regisetObject = aClass.newInstance();
                        //根据方法名找到对应的方法
                        Field fields = aClass.getDeclaredField(nameValue);
                        fields.setAccessible(true);
                        //对方法进行调用赋值
                        fields.set(regisetObject, map.get(refValue));
                    } else {
                        //构造方法注入
                        Attribute ref = elementSecend.attribute("ref");
                        String refValue = ref.getValue();
                        //通过构造注入
                        Object injetObject = map.get(refValue);
                        Class<?> injetObjectClass = injetObject.getClass();
                        Constructor<?> constructor = aClass.getConstructor(injetObjectClass.getInterfaces()[0]);
                        regisetObject = constructor.newInstance(injetObject);
                    }
                }
                //如果自动装配
                if (flage && regisetObject == null && attribute.getValue().equals("byType")) {
                    Field[] declaredFields = aClass.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        Class<?> setType = declaredField.getType();
                        Object injectObject = null;
                        int count = 0;
                        for (Map.Entry<String, Object> set : map.entrySet()) {
                            Class<?> temp = set.getValue().getClass().getInterfaces()[0];
                            if (temp.getName().equals(setType.getName())) {
                                injectObject = set.getValue();
                                count++;
                            }
                        }
                        if (count > 1) {
                            throw new RuntimeException("要一个返回2个");
                        }

                        if (injectObject != null) {
                            regisetObject = aClass.newInstance();
                            declaredField.setAccessible(true);
                            declaredField.set(regisetObject, injectObject);
                        }

                    }

                }


                if (regisetObject == null) {
                    regisetObject = aClass.newInstance();
                }
                map.put(calssIdValue, regisetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.spring.service.UserServiceImpl");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }

}
