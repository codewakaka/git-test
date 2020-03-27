package com.laoma.mystudy.filed;

public class ServiceA {
    @SimpleProject
    ServiceB serviceB;

    public void callB(){
        serviceB.action();
    }
    public ServiceB getB() {
        return serviceB;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();
        ServiceB b = SimpleContainer.getInstance(ServiceB.class);
        if(b != a.getB()){
            System.out.println("SimpleContainer: different instances");
        }
    }
}
