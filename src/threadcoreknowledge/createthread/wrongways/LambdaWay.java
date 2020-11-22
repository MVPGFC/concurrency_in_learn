package threadcoreknowledge.createthread.wrongways;

/**
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/31 8:50 下午
 */
public class LambdaWay {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
