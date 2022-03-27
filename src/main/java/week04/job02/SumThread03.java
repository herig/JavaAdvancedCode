package week04.job02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread03 implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public SumThread03(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        Homework03.sumResult = sum();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
