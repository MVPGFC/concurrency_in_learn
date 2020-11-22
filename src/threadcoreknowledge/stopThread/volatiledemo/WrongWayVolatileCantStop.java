package threadcoreknowledge.stopThread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 演示用volatile的局限part2。
 * 陷入阻塞时，volatile是无法停止线程的。此例中，生产的生产速度很快，消费者的消费速度很慢。
 * 也就是会出现阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费。
 * @author guofucheng
 * @version 1.0
 * @date 2020/11/21 上午3:05
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(5);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while(consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");

        //一旦消费者不需要更多数据了，我们应该让生产者也停下来，但实际情况
        producer.canceled=true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable {

    public volatile boolean canceled = false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100 && !canceled) {
                if (num % 2== 0) {
                    storage.put(num);
                    System.out.println(num + "是100的倍数,被放到仓库了");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止运行");
        }
    }
}

class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        if (Math.random()>0.95){
            return false;
        }
        return true;
    }
}
