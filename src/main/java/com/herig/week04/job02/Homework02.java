package com.herig.week04.job02;

import java.util.concurrent.CountDownLatch;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework02 {

    public static int sumResult;

    public static void main(String[] args) throws InterruptedException {


        
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SumThread02 sumThread02 = new SumThread02(countDownLatch);
        sumThread02.run();

        countDownLatch.await();

        int result = sumResult; //这是得到的返回值
        
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
         
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        
        // 然后退出main线程
    }
    

}
