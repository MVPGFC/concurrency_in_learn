package threadcoreknowledge.stopThread;

/**
 * 最佳实践：catch住了InterruptException后，优先选择在方法签名中抛出异常
 * 那么在run()方法中就会强制try/catch
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/2 9:35 下午
 */
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while(true && !Thread.interrupted()){
            System.out.println("go");
            //错误方法，低级的抛出异常，无法中断线程
            //throwInMethodwrong();
            try {
                //由于throwInMethod使用方法签名，这里就要求调用者强制处理，而且run()方法只能使用try/catch，而无法抛出Exception
                throwInMethod();
            } catch (InterruptedException e) {
                //由于throwInMethod正确的抛出了异常，这里就可以感知到，那么就可以做更多的逻辑
                // 比如：保存日志，停止程序
                System.out.println("save log");
                //恢复中断
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    //错误责任方在于该方法，该方法不应该直接把异常吞掉，而应该传递给调用者
    private void throwInMethodwrong(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //使用方法签名的方式，是正确的选择
    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}

