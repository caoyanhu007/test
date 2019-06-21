package com.proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		IRealStar realStar =new RealStar();
		RealStarHandler realStarHandler = new RealStarHandler(realStar);
		 //动态生成代理类和对象
		IRealStar proxy = (IRealStar)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IRealStar.class}, realStarHandler);
		proxy.bookTicket();
		proxy.sing();
		proxy.collectMoney();
	}
}
