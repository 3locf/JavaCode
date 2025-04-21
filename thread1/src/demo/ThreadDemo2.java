package demo;

//实现Runnable接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(" hello thread2");
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        //创建 Thread 类实例, 调⽤ Thread 的构造⽅法时将 Runnable 对象作为 target 参数.
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
