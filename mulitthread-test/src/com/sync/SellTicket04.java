package com.sync;

/**
 * 使用synchronize解决售票问题
 **/
public class SellTicket04 {
    public static void main(String[] args) {
        SellTick04 sellTick04 = new SellTick04();
        SellTick04 sellTick05 = new SellTick04();
        SellTick04 sellTick06 = new SellTick04();

        sellTick04.start();
        sellTick05.start();
        sellTick06.start();


    }

}



class SellTick04 extends Thread {
    private static int tickets = 30;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object){
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
