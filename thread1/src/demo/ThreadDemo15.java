package demo;

import java.util.Scanner;

public class ThreadDemo15 {
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
            System.out.println("hello t1");
        });


        Thread t2 = new Thread(() -> {
            //一定要确保持有锁，才谈释放
            synchronized (locker1) {
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("hello t2");
        });

        Thread t3 = new Thread(() -> {
            //一定要确保持有锁，才谈释放
            synchronized (locker1) {
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("hello t3");
        });


        Thread t4 = new Thread(()-> {
            Scanner scanner = new Scanner(System.in);
            scanner.nextInt();
            synchronized (locker1) {
                //随机唤醒一个阻塞线程
                locker1.notify();

                locker1.notify();
                locker1.notify();
                locker1.notify();
                locker1.notify();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
