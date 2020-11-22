package threadcoreknowledge.stopThread;

/**
 * 注意Thread.interrupted()方法的目标对象是"当前线程"，而不管本方法来自于哪个对象
 *interrupted @author guofucheng
 * @version 1.0
 * @date 2020/11/21 下午10:36
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                }
            }
        });

        threadOne.start();
        threadOne.interrupt();

        System.out.println(threadOne.isInterrupted());
        //当前线程就是main线程，到目前为止没有任何中断
        System.out.println(threadOne.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main线程结束");
    }
}
