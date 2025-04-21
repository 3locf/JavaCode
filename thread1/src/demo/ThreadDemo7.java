package demo;


public class ThreadDemo7 {
    private static boolean flg = true;
    public static void main(String[] args) {
        //lambda 和 匿名内部类的 变量捕获 要求变量是常量或事实变量
        //boolean flg = true;
        Thread t1 = new Thread(() -> {
            while(flg) {
                try {
                    System.out.println("hello world");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                System.out.println("t2线程开始休眠三秒，三秒之后，将修改flg的值");
                Thread.sleep(3000);
                flg = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

    }
}
