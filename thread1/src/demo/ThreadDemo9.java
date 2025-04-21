package demo;

public class ThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 4; i++) {
                System.out.println("hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 4; i++) {
                System.out.println("hello t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        //在哪个线程里面写 Thread.join() 方法，就是等待这个线程先完成它的任务
        System.out.println("主线程开始等待 t1 t2 线程完成任务");
        //无参版本
//        t1.join();
//        t2.join();

        t1.join(1000);
        t2.join(2000);
        System.out.println("等待完成!");

    }
}
