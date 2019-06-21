package com.io;

import java.io.File;

public class Demo1 {

	public static void main(String[] args) {
			/**
			 * 两个常量
			 * 1、路径分割符 ;
			 * 2、名称分割符 \(windows)   /(linux)
			 */
			System.out.println(File.pathSeparator);
			System.out.println(File.separator);
			//路径表示形式三种,推荐用第三种
			String path1 ="E:\\test\\image\\001.jpg";
			String path2 ="E:"+File.separator+"test"+File.separator+"image"+File.separator+"001.jpg";
			String path3 ="E:/test/image/001.jpg";
			System.out.println(path1);
			System.out.println(path2);
			System.out.println(path3);
			System.out.println("==================");
			
			/**
			 * 相对路径与绝对路径构造File对象：
			 * 1、相对路径两种方法：
			 * 		File(String parent, String child)
			 * 		File(File parent, String child)
			 * 2、绝对路径
			 * 		File(String name)
			 */
			//相对路径：
			String parentPath ="E:/test/image";
			String name ="002.jpg";
			File src =new File(parentPath, name);
			src =new File(new File(parentPath), name);
			System.out.println(src.getName());
			System.out.println(src.getPath());//绝对路径返回绝对的
			System.out.println(src.exists());
			if (src.isFile()) {
				System.out.println("是文件");
			} else {
				System.out.println("是文件夹");
			}
			System.out.println("==================");
			//绝对路径：
			src =new File("E:/test/image/002.jpg");
			System.out.println(src.getName());
			System.out.println(src.getPath());//相对路径返回相对的
			System.out.println(src.exists());
			if (src.isFile()) {
				System.out.println("是文件");
			} else {
				System.out.println("是文件夹");
			}
			System.out.println("==================");
			//没有盘符：以use.dir 当前工作空间目录构建
			src=new File("test.txt");
			System.out.println(src.getName());
			System.out.println(src.getPath());
			System.out.println(src.getAbsolutePath());//返回绝对路径
			System.out.println(src.exists());
			if (src.isFile()) {
				System.out.println("是文件");
			} else {
				System.out.println("是文件夹");
			}

	}

}
