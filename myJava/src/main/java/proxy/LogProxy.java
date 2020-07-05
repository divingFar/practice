package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogProxy implements InvocationHandler {
    Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    // 调用invoke方法之前执行
    private void before() {
        System.out.println(String.format("log start time[%s]", new Date()));
    }

    // 调用invoke方法之后执行
    private void after() {
        System.out.println(String.format("log end time[%s]", new Date()));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
}
