# JavaAdvancedCode
Java进阶训练营第九期毕业总结

1.JVM

技术关键点：

1.内存结构：  

堆 = 年轻代 （Eden区 + S0 + S1） + 老年代

栈 = n个栈帧(操作数栈 + 本地变量表 + class/method指针 + 返回值)

2.JVM参数：

XMS：初始堆内存

XMX：最大堆内存

XSS：线程栈大小

-XX:+HeapDumpOnOutOfMemoryError：内存溢出时自动dump

-XX:HeapDumpPath：内存溢出的dump路径

3.GC策略：

串行GC

并行GC

CMS GC

G1 GC

ZGC

Shenandoah GC

4.工具：

命令行：jps/jinfo/jstat/jheap

第三方：memory analysis/arthas

经验认识：JVM这一模块的重点在于GC策略和参数调优。当然前面的字节码技术、JVM内存结构等也很重要，有了这些才能明白
JVM调优的底层原理，调优的是什么（1.堆内存及各个分代的关系 2.选择合适的GC策略 3.STW时间）。而GC策略这里，则需
要根据情况来选择，如：java8，业务线程比较重要，需要所有线程来处理业务线程，那么可以选择并行GC；对延迟有要求，且
不希望业务线程停掉可以选择 CMS GC；4g以上内存，推荐G1 GC；再大的内存（T级别）推荐升级ZGC/Shenandoah GC。
参数方便，一方面合理分配各个分代的关系，另一方面应增加监控的参数，此外，监测的工具也应该提前准备好，真正出问题的
时候会派上用场。


2.NIO

技术关键点：

1.模型分类：

阻塞I/O模型：用户进程阻塞，直至数据准备好并拷贝完成

非阻塞I/O模型：内核立即返回，CPU继续做其他事，然后用户进程不断询问

I/O复用模型：通过select或pull 轮询，数据到达后，由轮询线程告知用户进程

信号驱动的I/O模型：无轮询，用户进程告诉内核需要什么数据，数据到达后会发送信号给用户进程

异步I/O模型：真正实现全流程的非阻塞，数据准备好并复制到用户空间，然后再发信号给用户进程

2.Netty框架：

异步

事件驱动

基于NIO

经验认识：涉及到I/O的操作比较慢，当有大量的请求进来的时候，NIO的技术就比较关键了，尤其是在多线程多核的时代。
Netty就是一个基于NIO的网络应用开发框架，很好的实现了NIO的三种模型：Reactor单线程模式、非主从Reactor多线
程模式、主从Reactor多线程模式。实际工作中还尚未用到，这一块还未掌握牢固，仍需复习巩固。


3.并发编程

技术关键点：

1.基础接口：

runnable：无返回值

callable：有返回值，可用future接收

2.线程池：

分类：

单线程线程池：newSingleThreadExecutor

固定容量线程池：newFixedThreadPool

可缓存线程池：newCachedThreadPool

定时线程池：newScheduledThreadPool

参数：

核心线程数：corePoolSize

最大线程数：maximumPoolSize

线程空闲超时时间：keepAliveTime

单位：unit

任务队列：workQueue

线程工厂：ThreadFactory

拒绝策略：handler

3.锁：synchronized、lock、condition、lockSupport

4.并发工具类：Semaphore、CountDownLatch、CyclicBarrier

5.并发原子类

6.线程安全类型

7.ThreadLocal

经验认识：并发线程的本质就是充分利用多核CPU，提高程序性能，不可避免的会发生“冲突”，这时就需要使用锁、原子类、线程安全类型等来控制，
确保程序的运行结果与预期结果一致。此外，无休止、不加控制的创建线程可能会导致程序崩溃，适得其反，因此需要线程池来管理线程，需根据程序
的需要创建特定类型的线程池。


