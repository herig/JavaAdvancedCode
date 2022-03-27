package week04.job02;

import java.util.concurrent.Callable;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread05 extends Thread {



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
    public void run() {
        Homework05.sumResult = sum();
    }
}
