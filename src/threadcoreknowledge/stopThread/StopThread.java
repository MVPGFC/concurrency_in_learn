package threadcoreknowledge.stopThread;

/**错误的停止方式，会导致线程运行一半突然停止，没有办法完成一个基本单位的操作（一个连队为一个基本单位），会造成脏数据（有的连队会多领取或者少领取装备）
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/10 9:02 下午
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        //模拟5个连队，每队10人，以连队为单位发放武器弹药，叫到号的士兵前去领取
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "领取完毕");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
