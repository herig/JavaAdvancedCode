package week04.job02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread04 implements Callable {



    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

    @Override
    public Object call() throws Exception {
        int sumResult = sum();
        return sumResult;
    }
}
