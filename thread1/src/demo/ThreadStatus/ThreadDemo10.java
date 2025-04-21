package demo.ThreadStatus;

//线程状态 ：NEW (虽然有了 Thread 对象，但是在内核中还没有真正启动线程 )
public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

        });

        System.out.println(t1.getState());
        t1.start();
    }
}
