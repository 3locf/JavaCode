package demo;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello thread3");
            }
        };

        thread.start();
    }
}
