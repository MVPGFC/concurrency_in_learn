package threadcoreknowledge.startThread;

/**
 * 演示重复执行start
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/31 9:57 下午
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
