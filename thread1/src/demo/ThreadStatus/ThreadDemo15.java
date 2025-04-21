package demo.ThreadStatus;
//线程状态 ： BLOCKED 由于 锁 竞争 锁引起的阻塞
public class ThreadDemo15 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            synchronized (locker1) {
                System.out.println("t1 获取到 locker1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker2) {
                    System.out.println("t1 获取到 locker2");
                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (locker2) {
                System.out.println("t2 获取到 locker1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (locker1) {
                    System.out.println("t2 获取到 locker1");
                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(2000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
