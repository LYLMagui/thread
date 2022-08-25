package com.mthread;


public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑cpu线程数量
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前电脑cpu线程数量是：" + cpuNums + "个");
    }
}
