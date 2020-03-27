package com.laoma.mystudy.localThread;

public class RequestContext {
    public static class Request {
    };

    private static ThreadLocal<String> loginUserId = new ThreadLocal<>();
    private static ThreadLocal<Request> requestThreadLocal = new ThreadLocal<>();

    public static void setCurrentUsreId(String userId) {
        loginUserId.set(userId);
    }

    public static String getCurrentUserId() {
        return loginUserId.get();
    }
    public static void setCurrentRequest(Request request){
        requestThreadLocal.set(request);
    }
    public static Request getCurrentRequest(){
        return requestThreadLocal.get();
    }
}
