package proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

import java.util.Date;


public class LogInterceptor implements MethodInterceptor {
    /**
     *
     * @param object  表示要增强的对象
     * @param method   表示拦截的方法
     * @param objects   数组表示参数列表
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示被代理对象方法的调用
     * @return  执行结果
     * @throws Throwable
     */
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(object, objects);//

        after();
        return result;
    }

    private void before() {
        System.out.println(String.format("log start time[%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time[%s] ", new Date()));
    }
}
