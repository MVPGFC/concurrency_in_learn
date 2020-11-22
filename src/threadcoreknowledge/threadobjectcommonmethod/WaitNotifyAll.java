package threadcoreknowledge.threadobjectcommonmethod;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;

/**
 * 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify, notifyAll
 * start先执行不代表线程先启动
 * @author guofucheng
 * @version 1.0
 * @date 2020/11/22 下午10:41
 */
public class WaitNotifyAll implements Runnable {

    private static final Object resourceA = new Object();
    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName()+" got resourceAlock.");
            try {
                System.out.println(Thread.currentThread().getName()+" wait to start");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+" is waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB= new Thread(r);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    //A,B两个线程都被唤醒了
                    //resourceA.notifyAll();
                    resourceA.notify();
                    System.out.println("ThreadC notified");
                }
            }
        });

        threadA.start();
        threadB.start();
//        System.out.println(threadB.getState());
        Thread.sleep(200);
//        System.out.println(threadA.getState());
        threadC.start();
    }
}
