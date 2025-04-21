package demo;

public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("hello thread8");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // throw new RuntimeException();
                    System.out.println("t1 线程被唤醒……");
                    break;
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();

        /**
         * t1.interrupt()能够设置标志位,能唤醒sleep中的线程，被唤醒的线程能够清除刚才设置的标志位
         */
    }
}
