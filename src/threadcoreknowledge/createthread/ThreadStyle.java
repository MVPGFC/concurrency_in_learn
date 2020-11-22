package threadcoreknowledge.createthread;

/**
 * 用thread方式实现线程
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/30 5:18 下午
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("用Thread方法实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
