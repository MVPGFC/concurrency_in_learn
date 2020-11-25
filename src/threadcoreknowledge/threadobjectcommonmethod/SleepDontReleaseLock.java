package threadcoreknowledge.threadobjectcommonmethod;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示sleep不释放lock（lock需要手动释放）
 * @author guofucheng
 * @version 1.0
 * @date 2020/11/25 上午2:18
 */
public class SleepDontReleaseLock implements Runnable{

    private static final Lock LOCK = new ReentrantLock();

    @Override
    public void run() {
        LOCK.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "被唤醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //必要的规范
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock
                sleepDontReleaseLock = new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock).start();
        new Thread(sleepDontReleaseLock).start();
    }
}
