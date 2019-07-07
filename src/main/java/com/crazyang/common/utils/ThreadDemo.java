package com.crazyang.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadDemo
 * @Description: 多线程面试题，开启十个线程进行计算
 * @Author zhouyang
 * @Date 2019/4/15 下午3:16.
 */

public class ThreadDemo {

    /**
     * 需要计算的总数
     */
    private static int CONST = 1000000;

    /**
     * 需要开启的线程数
     */
    private static int THREAD_CONST = 10;

    /**
     * 每个线程需要负责计算的数据
     */
    private static int SEGMENT_COUNT = CONST / THREAD_CONST;

    /**
     * 存总数据的位置
     */
    private static Long[] nums = new Long[CONST];

    /**
     * 存每个线程计算结果的位置
     */
    private static Long[] results = new Long[THREAD_CONST];
    /**
     * 完成求和的线程的个数
     */
    private static AtomicInteger complete = new AtomicInteger(0);

    private static final Object lock = new Object();

    public static void main(String[] args) {
        List list = new ArrayList();
        long startTime = System.nanoTime();
        for (int i = 0; i < CONST; i++) {
            nums[i] = Long.valueOf(i);
        }
        Computer computer = new Computer();
        for (int i = 0; i < THREAD_CONST; i++) {
            new Thread(computer, String.valueOf(i)).start();
        }
        Long sum = 0L;
        synchronized (lock) {
            try {
                System.out.println("等待计算结果");
                if (complete.get() < 10) {
                    lock.wait();
                }
                System.out.println("计算完成");
                for (int i = 0; i < THREAD_CONST; i++) {
                    sum = sum + results[i];
                }
                System.out.println("最终结果为：" + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        double second = (endTime - startTime) / Math.pow(10, 9);
        System.out.println("开启多个线程花费总时间为：" + second);

        long single = 0L;
        for (int i = 0; i < CONST; i++) {
            single = single + Long.valueOf(i);
        }
        System.out.println(single);
        long singleTime = System.nanoTime();
        double singleEnd = (singleTime - endTime) / Math.pow(10, 9);
        System.out.println("开启单线程花费总时间为：" + singleEnd);
    }


    /**
     * Runnable可以为多个线程共享
     */
    static class Computer implements Runnable {
        @Override
        public void run() {
            int segment = Integer.parseInt(Thread.currentThread().getName());
            int beginIndex = segment * SEGMENT_COUNT;
            int endIndex = (segment + 1) * SEGMENT_COUNT;
            Long sum = 0L;
            for (int i = beginIndex; i < endIndex; i++) {
                sum += i;
            }
            results[segment] = sum;
            System.out.println("线程" + segment + "求和的结果是" + sum);
            synchronized (lock) {
                int completeNumber = complete.addAndGet(1);
                if (completeNumber == THREAD_CONST) {
                    lock.notifyAll();
                }
            }
        }
    }
}



