package com.threaduse;

public class ThreadOne {

    public static void main(String[] args) throws InterruptedException {
        //创建Out对象，可以当线程使用
        Out out = new Out();
        //启动线程
        out.start();
//        out.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程正在执行第：" + i + "次，" + "线程名："+Thread.currentThread().getName());
            Thread.sleep(1000);
        }

    }

}

/**
 *  1. 当一个类继承了Thread类，该类就可以当做线程使用
 *  2. 重写run方法
 *  3. Thread 中的 run 方法是实现 Runnable 接口来的
 */

class Out extends Thread{
    //重写run方法
    @Override
    public void run() {
        for(int i = 0;i < 5; i++) {
            //每隔一秒输出一句Hello World
            System.out.println("Hello World" + ", " + i + ", 线程名：" + Thread.currentThread().getName() );

            //让程序休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}



