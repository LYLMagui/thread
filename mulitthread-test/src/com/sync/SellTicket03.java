package com.sync;

/**
 * 使用synchronize解决售票问题
 **/
public class SellTicket03 {
    public static void main(String[] args) {
        SellTick03 sellTick03 = new SellTick03();
        new Thread(sellTick03).start();// 开启第一个线程-窗口
        new Thread(sellTick03).start();// 开启第二个线程-窗口
        new Thread(sellTick03).start();// 开启第二个线程-窗口

    }

}


/**
 * 同步方法（静态）
 */
class SellTick03 implements Runnable {
    private static int tickets = 30;

    /**
     * 一个静态同步方法加上 synchronized，此时锁是加在类（SellTick03.class）上的
     */
    public synchronized static void m1() {

    }

    /**
     * 如果在静态方法中，实现一个同步代码块，需要在synchronized ()中传入当前类
     */
    public static void m2() {

        synchronized (SellTick03.class) {
            System.out.println("hello");
        }
    }


    @Override
    public void run() {
        while (true) {
            m2();
        }
    }
}
