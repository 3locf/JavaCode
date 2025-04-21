package demo;

import java.util.Scanner;

//内存可见性问题
public class ThreadDemo13 {
    private static volatile int n = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //会优化线程去内存里面读取数据的过程，直接在自己的缓存中读取数据
            while(n == 0) {

            }
            System.out.println("结束循环");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
             n = scanner.nextInt();
        }) ;

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
