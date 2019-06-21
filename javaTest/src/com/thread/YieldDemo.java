package com.thread;

/**
 * yield() ：静态方法，暂停当前正在执行的线程对象，并执行其他线程。
 * 				并没有严格意义上的暂停(只是让出cpu的调度)，后续CPU调度到还会继续执行
 * @author Administrator
 *
 */
public class YieldDemo extends Thread {
	public static void main(String[] args) {
		YieldDemo yieldDemo =new YieldDemo();
		yieldDemo.start();
		for (int i = 0; i < 100; i++) {
			if (i%20==0) {
				Thread.yield();//写在谁的线程体里就暂停谁，此处暂停main线程
			}
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
}
