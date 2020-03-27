package com.laoma.mystudy.filed;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleContainer {

    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        try {
            //如果此元素上 存在指定类型的注释，则返回true，否则返回false。
            boolean annotationPresent = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!annotationPresent) {
                return createInstance(cls);
            }
            Object obj  = instances.get(cls);
            if(obj != null){
                return (T) obj;
            }
            synchronized (cls){
                obj = instances.get(cls);
                if(obj == null){
                   obj = createInstance(cls);
                   instances.put(cls,obj);
                }
            }
            return (T) obj;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private static <T> T createInstance(Class<T> cls) throws Exception {
        //  创建此 Class 对象所表示的类的一个新实例
        T t = cls.newInstance();
        //获得该元素的所有注释
        // Annotation[] annotations = cls.getDeclaredAnnotations();
        //  返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.isAnnotationPresent(SimpleProject.class)) {
                if (f.isAccessible()) {
                    f.setAccessible(true);
                }
                Class<?> type = f.getType();
                f.set(t, getInstance(type));
            }
        }
        return t;
    }
}
