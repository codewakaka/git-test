package com.jvm.ex2;

/**
 * @author King老师
 * VM参数
 * -Xms30m -Xmx30m  -XX:MaxMetaspaceSize=30m
 *
 */
public class JVMObject {
    public final static String MAN_TYPE = "man"; // 常量
    public static String WOMAN_TYPE = "woman";  // 静态变量
    public static void  main(String[] args)throws Exception {
        Teacher T1 = new Teacher();
        T1.setName("Mark");
        T1.setSexType(MAN_TYPE);
        T1.setAge(36);
        for (int i=0;i<15;i++){//进行15次垃圾回收
            System.gc();
        }
        Teacher T2 = new Teacher();
        T2.setName("King");
        T2.setSexType(MAN_TYPE);
        T2.setAge(18);
        Thread.sleep(Integer.MAX_VALUE);//线程休眠
    }
}

class Teacher{
    String name;
    String sexType;
    int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSexType() {
        return sexType;
    }
    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
