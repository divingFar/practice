package designPattern.proxy;

public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    private Singleton getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (this) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
