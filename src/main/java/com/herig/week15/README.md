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
