package week04.job02;

import java.util.concurrent.Semaphore;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread10 implements Runnable {

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
        Homework10.lock.lock();
        Homework10.sumResult = sum();
        Homework10.lock.unlock();
    }
}
