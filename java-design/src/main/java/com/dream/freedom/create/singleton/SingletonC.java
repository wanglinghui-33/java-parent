package com.dream.freedom.create.singleton;

/**
 * 设计模式--单利模式--双重校验锁
 *
 *      有一种情况，两个线程ThreadA，ThreadB，如果threadA执行到了第一个if条件判断，instance = null；
 *
 *      ThreadB也执行到了if条件判断instance = null，所以A和B会依次执行同步代码块里的代码。
 *
 *      为了避免创建两个实例，因此又在同步代码块里添加了if条件进行二重检验。
 *
 */
public class SingletonC {

    private static volatile SingletonC singletonC = null;

    private SingletonC(){

    }


    /**
     *   Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
     *
     *   原因：
     *      1、此处涉及Java的指令重排优化。指令重排优化是指在不改变原语义的情况下，通过调整指令的执行顺序让程序运行地更快。
     *
     *      2、JVM中没有规定编译器优化的相关内容，也即JVM可以自由地进行指令重排序的优化。
     *
     *      3、此问题的关键在于由于指令重排序优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
     *
     *      4、在某个线程创建单例对象时，在构造函数被调用前，就为该对象分配了内存空间并将对象的字段设置为默认值。此时就可以将分配的内存地址赋值给instance字段了，
     *
     *          然而该对象可能还没初始化。若紧接着另一个线程来调用getInstance，获取到的就是状态不正确的对象，程序出错。
     *
     *
     *
     *  在JDK 1.5 之后的版本添加volatile 关键字，就避免以上的问题
     *
     *  volatile 关键字 的作用：
     *
     *      ① 多线程主要围绕可见性和原子性两个特性展开，使用volatile关键字修饰的变量，保证了其在多线程之间的可见性，即每次读取到的volatile变量，一定是最新的数据。
     *
     *      ② 代码底层执行的顺序是Java代码-->字节码-->根据字节码执行对应的C/C++代码-->C/C++代码被编译成汇编语言-->和硬件电路交互。
     *
     *          实际中，为了获取更好的性能，JVM可能会对指令进行重排序，多线程下可能会出现一些意想不到的问题。使用volatile则会禁止语义重排序，也一定程度上降低了代码执行效率。
     *
     *          实践角度而言，volatile的一个重要作用就是和CAS结合，保证了原子性。
     *
     *      volatile是一个特殊的修饰符，只有成员变量才能使用它。在Java并发程序缺少同步类的情况下，多线程对成员变量的操作对其他线程是透明的。
     *
     *      volatile变量可以保证下一个读取操作会在前一个写操作之后发生。
     *
     * @return
     */
    public static SingletonC getInstance() {
        if (singletonC == null) {
            synchronized (SingletonB.class) {
                if (singletonC == null){
                    singletonC = new SingletonC();
                }
            }
        }
        return singletonC;
    }

    public void print(){
        System.out.println("双重校验锁单利模式---Hello World");
    }

}
