package com.threadstatus;

/**
 * 线程的状态
 */
public class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {


        Status status = new Status();
        System.out.println(status.getName() + " 线程状态： " + status.getState());
        status.start();
        //当线程状态不为终止状态时，输出线程的当前状态
        while (Thread.State.TERMINATED != status.getState()) {
            System.out.println(status.getName() + " 线程状态： " + status.getState());
            Thread.sleep(500);
        }
        //输出终止状态
        System.out.println(status.getName() + " 线程状态： " + status.getState());
    }
}

class Status extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 7; i++) {
                System.out.println("hello" + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }

    }
}