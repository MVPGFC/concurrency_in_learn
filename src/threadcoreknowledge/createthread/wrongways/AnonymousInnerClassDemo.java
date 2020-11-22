package threadcoreknowledge.createthread.wrongways;

/**
 * 用匿名内部类实现线程
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/31 8:46 下午
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
