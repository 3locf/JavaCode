package demo;

public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for(int i = 0; i < 3; i++) {
                System.out.println("hello thread"+i);
            }
        });

        t.start();
        //线程状态
        System.out.println(t.getState());
        //线程名字
        System.out.println(t.getName());
        //线程的标识符
        System.out.println(t.getId());

        /**
         * 前台线程：如果这个线程在执行过程中，能够阻止进程结束，此时这个线程就是“前台线程”
         * 后台线程：如果这个线程在执行过程中，不能阻止线程结束（虽然该线程在执行着，但是进程要结束了，此时这个线程也会被带走），此时这个线程就是“后台进程”
         */
        //是否是后台线程
        System.out.println(t.isDaemon());
        //是否被中断
        System.out.println(t.isInterrupted());
        //线程的优先级
        System.out.println(t.getPriority());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //是否存活
        System.out.println(t.isAlive());

    }
}
