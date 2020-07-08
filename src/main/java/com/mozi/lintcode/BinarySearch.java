package com.mozi.lintcode;

import java.util.Arrays;

/**
 * @author :zhouwenbin
 * @time   :19/9/24
 * @comment:java实现二分查找-两种方式
 * https://blog.csdn.net/maoyuanming0806/article/details/78176957
 **/
public class BinarySearch {

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,21,22,31,38,49,50};
		System.out.println("二分查找的下标为：" + binarySearch(arr,22,0,arr.length-1));



		int Sum=28;
		System.out.println("快速找出一个数组中的两个数字，让这两个数字之和等于一个给定的值:"+getSumNum(arr,Sum));

	}



	static String getSumNum(int[] arr,int Sum)   //arr为数组，Sum为和
	{
		int i, j;
		for (i = 0, j = arr.length - 1; i < j; ) {
			if (arr[i] + arr[j] == Sum)
				return i + "," + j;
			else if (arr[i] + arr[j] < Sum)
				i++;
			else
				j--;
		}
		return "-1";
	}


	public static int binarySearch(int[] arr,int key,int low,int high){
		if(key<arr[low] || key>arr[high] || low >high)
			return -1;

		int mid=(low+high)/2;
		if(key<arr[mid])
			return binarySearch(arr,key,low,mid-1);
		else if(key>arr[mid])
			return binarySearch(arr,key,mid+1,high);
		else
			return mid;
	}

}
