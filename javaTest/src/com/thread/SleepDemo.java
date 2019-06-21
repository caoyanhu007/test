package com.thread;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时10秒
 * @author Administrator
 *
 */
public class SleepDemo {

	public static void main(String[] args) throws InterruptedException {
		Date endTime =new Date(System.currentTimeMillis()+10*1000);
		long end =endTime.getTime();
		while (true) {
			//输出
			System.out.println(new SimpleDateFormat("hh:mm:ss").format(endTime));
			//等待一秒
			Thread.sleep(1000);
			//构建下一秒时间
			endTime =new Date(endTime.getTime()-1000);
			//10秒以内继续，否则退出
			if (end-10000>endTime.getTime()) {
				break;
			}
		}
	}

}
