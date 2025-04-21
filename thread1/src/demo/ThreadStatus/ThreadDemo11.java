package demo.ThreadStatus;

//线程状态 ： RUNNABLE (正在运行的线程或随时可以被调度上 cpu 上执行的线程)
public class ThreadDemo11 {
    public static void main(String[] args) {
        Thread t2  = new Thread(() -> {
            while(true) {

            }
        });
        t2.start();
        System.out.println(t2.getState());

    }
}
