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

4.Spring与ORM框架

技术关键点：

1.AOP：面向切面编程、控制反转（依赖注入）

2.Spring Bean

3.Spring Xml：通过配置完成Bean的注入，通过上下文获取Bean等

4.SpringBoot：简化配置，spring的脚手架

5.Hibernate：全自动ORM框架

6.Mybatis：半自动ORM框架

7.Stream流操作：流操作，本质上还是多线程，可以大幅度简化代码

8.Lambda表达式：语法糖

经验认识：通过AOP技术可以对现有的代码进行增强，可以减少代码的入侵，达到松耦合的目的。利用SpringBoot可以极大程度地简化配置，
很好地集成各种框架和组件。ORM框架上推荐Mybatis，显式的SQL更加灵活，也更容易审查。Stream 和 Lambda 表达式的熟练运用可以很
大程度上减轻代码量，提高开发效率，但对于新人或不熟悉该语法的人来说，阅读上可能有些困难，且处理不好很容易报空指针异常。

5.MySQL 数据库和 SQL

技术关键点：

1.SQL语言

数据查询语言DDL：保留字 SELECT 是 DQL（也是所有 SQL）用得最多的动词，其他 DQL 常用的保留字有 WHERE，ORDER BY，GROUP BY
和 HAVING。

数据操作语言DML：包括动词  INSERT、UPDATE 和  DELETE。它们分别用于添加、修改和删除。

事务控制语言TCL：它的语句能确保被  DML 语句影响的表的所有行及时得以更新。包括COMMIT（提交）命令、SAVEPOINT（保存点）命令、
ROLLBACK（回滚）命令。

数据控制语言DCL：它的语句通过  GRANT 或  REVOKE 实现权限控制，确定单个用户和用户组对数据库对象的访问。某些  RDBMS 可用  
GRANT 或  REVOKE 控制对表单个列的访问。

数据定义语言DDL：其语句包括动词  CREATE,ALTER 和  DROP。在数据库中创建新表或修改、删除表(CREAT TABLE 或  DROP TABLE);
为表加入索引等。

指针控制语言CCL：它的语句，像  DECLARE CURSOR，FETCH INTO 和  UPDATE WHERE CURRENT 用于对 一个或多个表单独行的操作。

2.MySQL事务

事务可靠性模型 ACID：

Atomicity原子性：原子性，一次事务中的操作要么全部成功，要么全部失败。

Consistency一致性：一致性，跨表、跨行、跨事务，数据库始终保持一致状态。

Isolation隔离性： 隔离性，可见性，保护事务不会互相干扰，包含4种隔离级别。

Durability持久性：持久性，事务提交成功后，不会丢数据。如电源故障，系统崩溃。

3.MySQL事务隔离级别

读未提交: READ UNCOMMITTED

读已提交:READ COMMITTED

可重复读:REPEATABLE READ

可串行化:SERIALIZABLE

4.MySQL锁

表级锁

共享意向锁（IS）: 打算在某些行上设置共享锁

排他意向锁（IX）: 打算对某些行设置排他锁

Insert 意向锁: Insert 操作设置的间隙锁

其他：自增锁（AUTO-IN）；LOCK TABLES/DDL

行级锁

记录锁（Record）: 始终锁定索引记录，注意隐藏的聚簇索引

间隙锁（Gap）: 锁住一个范围

临键锁（Next-Key）: 记录锁+间隙锁的组合; 可“锁定”表中不存在记录

谓词锁（Predicat）: 空间索引

5.存储引擎

MyISAM

不支持事务，也不支持外键约束，只支持全文索引，数据文件和索引文件是分开保存的

InnoDB

支持事务，支持4个事务隔离级别

经验认识：MySQL是一个关系型数据库管理系统，MySQL数据库和SQL这一模块的重点在于了解基础的SQL语句，索引，事务。当然MySQL底层
的存储引擎以及相对应的数据结构也很重要，了解了这些才能更好地理解表结构如何设计，SQL如何优化。更进一步地，我们可以将用上mysql
的主从复制，以及与代码结合实现读写分离，从而真正做到实现mysql的高可用。



