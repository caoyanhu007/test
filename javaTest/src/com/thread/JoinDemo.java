package com.thread;

/**
 * join()合并线程，main线程阻塞，等待调用join的线程终止后再执行main线程
 * @author Administrator
 *
 */
public class JoinDemo extends Thread{

	public static void main(String[] args) throws InterruptedException {
		JoinDemo joinDemo = new JoinDemo();
		joinDemo.start();//就绪，CPU调度到就运行
		for (int i = 0; i < 100; i++) {
			if (i==50) {
				joinDemo.join();
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
