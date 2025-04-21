package demo;

import java.util.Scanner;

// wait() notify()

/**
 * wait做了三件事，释放锁，进入阻塞等待，准备接收通知，收到通知之后。唤醒，并且重新尝试获取锁
 * 可以解决线程安全问题
 */
public class ThreadDemo14 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //一定要确保持有锁，才谈释放
            synchronized (locker1) {
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("hello");
        });

        Thread t2 = new Thread(()-> {
            Scanner scanner = new Scanner(System.in);
            scanner.nextInt();
            synchronized (locker1) {
                locker1.notify();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
