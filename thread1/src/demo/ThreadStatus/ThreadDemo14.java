package demo.ThreadStatus;
//线程状态:WAITING 无超时时间的等待
public class ThreadDemo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        Thread t1 = new Thread(() -> {
                System.out.println(thread.getState());
        });

        t1.start();
        t1.join();



    }
}
