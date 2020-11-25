package threadcoreknowledge.threadobjectcommonmethod;

/**
 * 两个线程交替打印0～100的奇偶数，用synchronized关键字实现author
 * guofucheng
 * @version 1.0
 * @date 2020/11/24 下午11:06
 */
public class WaitNotifyOddEvenSyn {

    public static int count = 0;
    private static final Object lock = new Object();
    //新建2个线程
    //1个只处理偶数，一个只处理奇数（位运算）
    //用synchronized来通信
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" +count++);
                        }
                    }
                }
            }
        }, "偶数");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100){
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" +count++);
                        }
                    }
                }
            }
        }, "奇数");

        thread1.start();
        thread2.start();
    }
}
