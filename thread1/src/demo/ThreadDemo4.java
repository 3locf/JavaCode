package demo;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" hello thread4");
            }
        });
        t.start();
    }
}
