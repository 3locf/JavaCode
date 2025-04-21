package demo.ThreadStatus;
//线程状态 TIME_WAITING 有超时时间的等待
public class ThreadDemo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());
    }
}
