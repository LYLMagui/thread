package com.deadlock;


public class ThreadDeadLock {
    public static void main(String[] args) {

        DeadLock A = new DeadLock(true);
        DeadLock B = new DeadLock(false);

        A.setName("A线程");
        B.setName("B线程");

        A.start();
        B.start();

    }
}

class DeadLock extends Thread{
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLock(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        /*
            代码分析：
            1. 如果flag为True，线程A 就会先得到/持有o1对象锁，然后去尝试获取o2对象锁
            2. 如果 线程A 得不到 o2 对象锁，就会 Blocked（阻塞）
            3. 如果 flag 为 False ，线程B 就会先得到/持有o2对象锁，然后去尝试获取o1对象锁
            4. 如果 线程B 得不到 o1 对象锁，就会 Blocked（阻塞）

            简单来说：A线程想拿B线程的对象锁，B线程想拿A线程的对象锁，两个线程互不相让，结果造成死锁
         */
        if(flag){
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}