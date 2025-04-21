package demo.threadcase;

//懒汉模式

public class ThreadLazySingle {
    //此处先把这个实例引用设为Null，先不着急创建实例
    private static ThreadLazySingle instance = null;

    public static ThreadLazySingle getInstance() {
        if(null == instance) {
            instance = new ThreadLazySingle();
        }
        return instance;
    }

    private ThreadLazySingle() {};
}

class ThreadLazySingle2 {
    private static ThreadLazySingle2 instance = null;
    private static final Object locker = new Object();
    public static ThreadLazySingle2 getInstance() {
        if(null == instance) {
            synchronized (locker) {
                if(null == instance) {
                    instance = new ThreadLazySingle2();
                }
            }
        }
        return instance;
    }

    private ThreadLazySingle2() {};
}

/**
 * 上述单例模式，在多线程环境下存在线程安全问题
 */
class ThreadLazySingle1 {
    private static volatile ThreadLazySingle1 instance = null;
    private static final Object locker = new Object();

    public static ThreadLazySingle1 getInstance() {
        //此处的if判定是否需要加锁
        if(null == instance) {
            //由于只需要第一次创建出来实例就行，后续的代码，都是单纯的 读 操作，此时 getInstance不加锁也是 线程安全的，没有必要加锁
            //当前写法，只要调用getInstance,都会触发加锁操作，此时虽然没有加锁操作了，但是也会因为加锁，产生阻塞，影响到性能
            synchronized (locker) {
                //此处的if判断是否要创建对象
                if(null == instance) {
                    //这个代码可能会因为指令重排序，引起线程安全问题 所以上面应该加上 volatile 关键字
                    instance = new ThreadLazySingle1();
                }
            }
        }
        return instance;
    }

    private ThreadLazySingle1() {};
}
