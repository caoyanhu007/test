package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 处理器对象
 * @author Administrator
 *
 */
public class RealStarHandler implements InvocationHandler {
	IRealStar realStar;
	
	public RealStarHandler(IRealStar realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("======begin======");
		if ("sing".equals(method.getName())) {
			method.invoke(realStar, args);
		}
		System.out.println("======end======");
		return null;
	}

}
