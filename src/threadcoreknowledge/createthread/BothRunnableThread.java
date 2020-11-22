package threadcoreknowledge.createthread;

/**
 * 同时使用Runnable和Thread同时使用线程的方式
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/30 5:36 下午
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
