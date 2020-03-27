package com.laoma.mystudy.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class MethodAnnotations {

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface  QueryParam{
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface  DefaultValue{
        String value() default "";
    }

    public void hello(@QueryParam("action")String action,@QueryParam("sort") @DefaultValue("asc")String sort){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<MethodAnnotations> cls = MethodAnnotations.class;
        Method method = cls.getMethod("hello", new Class[]{String.class, String.class});
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println("annotations for paramer " + (i + 1));
            Annotation[] annotation = annotations[i];
          /*  if(annotation instanceof  QueryParam){
              QueryParam queryParam = (QueryParam)  annotation;

            }*/
        }

    }
}
