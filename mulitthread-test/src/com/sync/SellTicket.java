package com.sync;

/**
 * 使用synchronize解决售票问题
 **/
public class SellTicket {
    public static void main(String[] args) {
        SellTick sellTick = new SellTick();
        new Thread(sellTick).start();// 开启第一个线程-窗口
        new Thread(sellTick).start();// 开启第二个线程-窗口
        new Thread(sellTick).start();// 开启第二个线程-窗口

    }

}


//实现Runnable接口方式，使用synchronize实现线程同步
class SellTick implements Runnable {
    private static int tickets = 30;
    @Override
    public synchronized void run() { //在同一个时刻，只能有一个线程来执行run方法

        while (true) {
            if (tickets <= 0) {
                System.out.println("售票结束...");
                break;
            }

            System.out.println("线程：" + Thread.currentThread().getName() + "，卖了一张票，" +
                    "还剩下：" + (--tickets) + "张票");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
