package demo;
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
