package threadcoreknowledge.sixstates;

/**
 * 展示线程的new、runnable、terminated状态。即使正在运行，也是
 *runnable状态。而不是running
 * @author guofucheng
 * @version 1.0
 * @date 2020/11/22 下午2:38
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE的状态，即使正在运行，也是RUNNABLE，而不是RUNNING
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TERMINATED状态
        System.out.println(thread.getState());
    }
}
