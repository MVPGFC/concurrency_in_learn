package threadcoreknowledge.threadobjectcommonmethod;

import sun.lwawt.macosx.CThreading;

/**
 * 两个线程交替打印0～100的奇偶数，用wait和notify
 * @author guofucheng
 * @version 1.0
 * @date 2020/11/24 下午11:22
 */
public class WaitNotifyPrintOddEveWait {

    private static int count = 0;
    private static Object lock = new Object();

    //1、拿到锁，就打印
    //2、打印完，唤醒其他线程，自己休眠
    static class TurningRunner implements Runnable {
        @Override
        public void run() {
            while(count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //任务没结束，释放锁且休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurningRunner(),"偶数").start();
        Thread.sleep(100);
        new Thread(new TurningRunner(),"奇数").start();
    }
}
