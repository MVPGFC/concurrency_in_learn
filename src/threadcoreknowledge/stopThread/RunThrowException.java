package threadcoreknowledge.stopThread;

/**
 * run无法抛出checked Exception，只能使用try/catch
 * @author guofucheng
 * @version 1.0
 * @date 2020/9/2 10:42 下午
 */
public class RunThrowException {
    //普通方法
    public void aVoid() throws Exception {
        throw new Exception();
    }

    //run方法
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            //原因是run方法是override的，只是重写了run方法，其顶层接口没有进行任何异常处理，所以只能使用try/catch
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
