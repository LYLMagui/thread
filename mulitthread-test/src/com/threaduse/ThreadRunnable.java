package com.threaduse;


/**
 * 使用 Runnable 方法实现多线程
 */
public class ThreadRunnable {
    public static void main(String[] args) {
        Rab rab = new Rab();
        //创建Thread对象 传入run，调用start方法开启多线程
        Thread thread = new Thread(rab);
        thread.start();
    }
}

class Rab implements Runnable{

    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("诶嘿！" + (++count) + Thread.currentThread().getName() );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count > 5){
                break;
            }
        }
    }
}
