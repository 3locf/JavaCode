package demo.ThreadStatus;
//线程状态：TERMINATED 虽然Thread对象还在，但是内核中的线程已经被销毁了
public class ThreadDemo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {

        });

        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());

    }
}
