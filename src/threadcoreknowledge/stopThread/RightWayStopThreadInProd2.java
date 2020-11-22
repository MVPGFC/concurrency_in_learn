package threadcoreknowledge.stopThread;

/**
 * 最佳实践：在catch中调用Thread.currentThread.interrupt()来恢复中断状态，以便后续执行中，仍然能够检测到刚才发生的中断，
 * 回到RightWayStopThreadInProd中补上中断，让它跳出循环
 *
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/2 9:35 下午
 */
public class RightWayStopThreadInProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序运行结束");
                break;
            }
            reInterrupt();
        }
    }

    //恢复中断的处理
    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}

