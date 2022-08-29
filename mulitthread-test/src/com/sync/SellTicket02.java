package com.sync;

/**
 * 使用synchronize解决售票问题
 **/
public class SellTicket02 {
    public static void main(String[] args) {
        SellTick02 sellTick02 = new SellTick02();
        new Thread(sellTick02).start();// 开启第一个线程-窗口
        new Thread(sellTick02).start();// 开启第二个线程-窗口
        new Thread(sellTick02).start();// 开启第二个线程-窗口

    }

}

/**
 * 同步方法（非静态）
 */
//实现Runnable接口方式，使用synchronize实现线程同步
class SellTick02 implements Runnable {
    private static int tickets = 30;
    @Override
    public void run() {

        while (true) {
            //同步代码块
            synchronized (this){
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
}
