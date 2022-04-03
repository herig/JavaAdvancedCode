package com.herig.week04.job02;

import java.util.concurrent.CountDownLatch;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread02 implements Runnable{

    private CountDownLatch countDownLatch;

    public SumThread02(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        Homework02.sumResult = sum();
        countDownLatch.countDown();
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
