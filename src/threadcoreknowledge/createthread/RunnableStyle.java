package threadcoreknowledge.createthread;

/**
 * 用Runnable方式创建线程
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/30 4:50 下午
 */
public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}
