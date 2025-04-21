package demo;

public class ThreadDemo5 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("hello thread5");
        });

        t.start();
    }
}
