package threadcoreknowledge.createthread.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 * @author guofucheng
 * @version 1.0
 * @date 2020/8/31 8:39 下午
 */
public class DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
