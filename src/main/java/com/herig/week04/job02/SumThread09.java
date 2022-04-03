package com.herig.week04.job02;

import java.util.concurrent.Semaphore;

/**
 * @author hxh
 * @date 2022/3/27 - 18:57
 */
public class SumThread09 implements Runnable {

    private Semaphore semaphore;

    public SumThread09(Semaphore semaphore){
        this.semaphore = semaphore;
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

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Homework09.sumResult = sum();
        semaphore.release();
    }
}
