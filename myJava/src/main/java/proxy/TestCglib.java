package proxy;

import net.sf.cglib.proxy.Enhancer;

public class TestCglib {
    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(logInterceptor);

        UserService userService = (UserService) enhancer.create();
        userService.update();
        userService.select();
    }
}
