package threadcoreknowledge.startThread;

/**
 * 对比start和run两种启动线程的方式
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/31 9:29 下午
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
