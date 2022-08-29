package com.threadexit;

/**
 *  案例：线程退出
 *  方式：通知方式
 */
public class ThreadExit01 {

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start(); // 开启线程
        Thread.sleep(5 * 1000); //主线程休眠5秒
        t1.setFlag(false); //更改标志结束线程
        System.out.println("线程结束");
    }
}


class T1 extends Thread{
    //计数
    private int count = 0;

    //标志
    private boolean flag = true;

    @Override
    public void run() {

        while (flag){

            System.out.println("诶嘿!  " + (++count));
            try {
                //休眠100ms
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //设置标志的值
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}