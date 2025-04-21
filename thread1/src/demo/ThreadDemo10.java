package demo;

/**
 * 线程不安全原因:
 * 1.线程在操作系统重是随机调度，抢占式执行的
 * 2.多个线程修改同一个变量
 * 3.修改操作，不是 “原子的”
 * 4.内存可见性问题
 * 5.指令重排序问题
 */
public class ThreadDemo10 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 50000; i++) {
                count += 1;
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 50000; i++) {
                count += 1;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //结果是不可预期的
        System.out.println(count);
    }
}
