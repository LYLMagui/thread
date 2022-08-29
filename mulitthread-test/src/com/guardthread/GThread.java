package com.guardthread;


/**
 * 设置守护线程
 *  如果我们希望当主线程结束后，子线程自动结束，只需要将子线程设置为守护线程
 */
public class GThread {

    public static void main(String[] args) throws InterruptedException {
        //创建守护线程对象
        MyDaemonThread myDaemonThread = new MyDaemonThread();

        //开启守护线程
        myDaemonThread.setDaemon(true);

        //运行子线程
        myDaemonThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程在运行中。。。");
            Thread.sleep(1000);
        }

    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        while (true){ //无限循环
            try {
                Thread.sleep(1000); //休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程在运行中。。。");
        }
    }
}
