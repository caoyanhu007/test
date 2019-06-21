package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序方法集
 * @author Administrator
 *
 */
public class Sort {

	public static void main(String[] args) {
			int[] arr ={9,6,7,8,5,1,3,2,4};
			//sort1(arr);
			//sort2(arr);
			sort3(arr);
	}
	
	/**
	 * 版本1：最简单排序，循环次数多，效率低
	 * @param arr
	 */
	public static void sort1(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println("第"+(i+1)+"趟");
			for (int j = 0; j <arr.length-1; j++) {
				System.out.print("第"+(j+1)+"次");
				if (arr[j]>arr[j+1]) {
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	
	/**
	 * 版本2：减少每趟的循环次数
	 * @param arr
	 */
	public static void sort2(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println("第"+(i+1)+"趟");
			for (int j = 0; j <arr.length-1-i; j++) {  // -i
				System.out.print("第"+(j+1)+"次");
				if (arr[j]>arr[j+1]) {
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	
	/**
	 * 版本3：最终版，加标识符，考虑有序
	 * @param arr
	 */
	public static void sort3(int[] arr){
		boolean sorted =true;
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println("第"+(i+1)+"趟");
			sorted =true;//假定有序
			for (int j = 0; j <arr.length-1-i; j++) {// -i
				System.out.print("第"+(j+1)+"次");
				if (arr[j]>arr[j+1]) {
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					sorted =false;//假定失败
				}
				System.out.println(Arrays.toString(arr));
			}
			if (sorted) {//减少趟数
				break;
			}
		}
	}

}
