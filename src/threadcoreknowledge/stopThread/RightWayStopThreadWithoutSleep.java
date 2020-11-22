package threadcoreknowledge.stopThread;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * run()中没有sleep或者wait，停止线程
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/1 10:56 上午
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        int num = 0;
        //Thread.currentThread().isInterrupted()是对于interrupt方法的相应处理，没有的话，线程无法中断
        while(!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2){
            if (num % 10000 == 0)
                System.out.println(num + "是一万的倍数");
            num++;
        }
        System.out.println("任务结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
