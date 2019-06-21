package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取Class反射对象
 * @author Administrator
 *
 */
public class ReflectionDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String path ="com.reflection.User";
		try {
			/**
			 * 对象是表示或封装一些数据。
			 * 一个类被加载后，JVM会创建一个对应的类的Class对象，类的整个结构信息会放到对应的Class对象中。
			 * 这个Class对象就像一面镜子一样，通过这面镜子我们可以看到类的全部信息。
			 */
			Class<User> clazz =(Class<User>) Class.forName(path);//最常用获取Class对象的方法
			System.out.println(clazz);
			System.out.println(clazz.hashCode());//获得地址
			System.out.println(clazz.getName());//获得包名+类名
			System.out.println(clazz.getSimpleName());//获得类名
/*			Class<?> strClazz =String.class;
			Class<?> strClazz1 =path.getClass();
			System.out.println(strClazz.hashCode()==strClazz1.hashCode());*/
			
			//获取属性信息
			Field[] Fields = clazz.getDeclaredFields();//获取所有属性。clazz.getFields()只能获取public属性
			for (Field field : Fields) {
				System.out.println("属性"+field);
			}
			Field field = clazz.getDeclaredField("name");//根据属性名称获取属性
			System.out.println(field.getName());
			
			//获取方法信息
			Method[] method = clazz.getDeclaredMethods();
			for (Method method2 : method) {
				System.out.println("方法"+method2);
			}
			Method method1 = clazz.getDeclaredMethod("getName");
			System.out.println(method1);
			Method method2 = clazz.getDeclaredMethod("setName", String.class);//如果方法有参，则必须传递参数类型的Class对象
			System.out.println(method2);
			
			//获取构造器信息
			Constructor<User>[] constructors = (Constructor<User>[]) clazz.getDeclaredConstructors();
			for (Constructor<User> constructor : constructors) {
				System.out.println("构造器"+constructor);
			}
			Constructor<User> constructor = clazz.getDeclaredConstructor(int.class,String.class,int.class);//获取有参构造器
			System.out.println(constructor);
			
			 //通过反射API调用构造方法，构造对象
			User user1 = clazz.newInstance();//其实是调用了user的无参构造方法
			System.out.println(user1);
			Constructor<User> constructor1 = clazz.getDeclaredConstructor(int.class,String.class,int.class);
			User user2 = constructor1.newInstance(1,"小王",28);
			System.out.println(user2.getName());
			
			//通过反射API动态调用普通方法
			Method method3 = clazz.getDeclaredMethod("setName", String.class);
			method3.invoke(user1, "小李");
			System.out.println(user1.getName());
			
			//通过反射API操作属性
			Field field1 = clazz.getDeclaredField("name");
			field1.setAccessible(true);//不需要做安全检查，可以直接访问
			field1.set(user1, "小张");//通过反射直接写属性
			System.out.println(user1.getName());
			System.out.println(field1.get(user1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
