package com.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		long start =System.currentTimeMillis();
		int threadNum =10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);//倒数计数器
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						Object obj =Singleton.getInstance();
						System.out.println(obj);
					}
					countDownLatch.countDown();//计数器减一
				}
			}).start();
		}
		countDownLatch.await();//main线程阻塞，只到计数器变为0，才会继续往下走
		long end =System.currentTimeMillis();
		System.out.println("总耗时"+(end-start));
	}

}
