package threadcoreknowledge.stopThread;

/**
 * 如果while里面try/catch，中断会失效
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/2 8:52 下午
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            //无论是否检查中断，都不能中断掉这个线程
            while(num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
