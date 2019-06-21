package com.thread;
/**
 * 单例创建的方式
 */


/**
 * 1、懒汉式
 * 1）、构造器私有化
 * 2）、声明私有的静态属性
 * 3）、对外提供访问属性的静态方法，确保该对象存在
 * @author Administrator
 *
 */
public class Singleton {
	
	private static Singleton instance;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if (null==instance) {//提升效率
			synchronized (Singleton.class) {//锁定类信息
				if (null==instance) {//安全
					instance =new Singleton();
				}
			}
		}
		return instance;
	}

}


/**
 * 2、恶汉式
 * 1）、构造器私有化
 * 2）、声明私有的静态属性，同时创建该对象
 * 3）、对外提供访问属性的静态方法
 * @author Administrator
 *
 */
 class Singleton1 {
	//内部类，因为类在使用的时候才加载，因此用内部类可延缓加载时间，等用到的时候再加载，提高效率
	private static class SingletonHolder{
		//类加载时立即加载这个对象，天然的线程安全，所以下面的方法无需同步
		private static Singleton1 instance =new Singleton1();
	}
	private Singleton1(){
		
	}
	public static Singleton1 getInstance(){
		return SingletonHolder.instance;
	}

}
