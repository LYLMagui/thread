package com.example;


/**
 * 使用多线程模拟三个窗口同时售30张票
 */
public class SellTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();


        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();


    }
}

/**
 * 继承Thread写法
 */
class Ticket implements Runnable{
    private static int ticketNum = 30; //设置为静态可以让多个线程共享
    @Override
    public void run() {

        while (true){
            if (ticketNum <= 0){
                System.out.println("售票结束。。。。");
                break;
            }

            System.out.println(Thread.currentThread().getName() + "卖出了一张票, "+
                    "还剩下：" + (--ticketNum) + "票");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
