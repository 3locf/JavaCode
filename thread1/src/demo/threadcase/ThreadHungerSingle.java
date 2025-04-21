package demo.threadcase;
//单例模式 饿汉方式实现
//饿 的意思就是 “迫切”
//在类被加载的时候，就会创建出这个单例的实例

public class ThreadHungerSingle {

    private static ThreadHungerSingle instance = new ThreadHungerSingle();

    public static ThreadHungerSingle getInstance() {
        return instance;
    }

    //单例模式最关键部分
    private ThreadHungerSingle() {};
}

class Test {
    public static void main(String[] args) {
        ThreadHungerSingle t1 = ThreadHungerSingle.getInstance();
        ThreadHungerSingle t2 = ThreadHungerSingle.getInstance();
        System.out.println(t1 == t2);
    }
}


