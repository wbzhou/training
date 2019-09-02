package com.mozi.lintcode.sort;

import java.util.Arrays;

/**
 * Created by weekend on 2019/2/23.
 */
/*
 * 冒泡排序
 /


 /*
 * 冒泡排序
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {0, 3, 8, 9, 10, 11};
//		int[] arr = {4, 3, 5, 1, 8, 2};
		boolean flag = true;
		int index=0;
		for (int i = 0; i < arr.length; i++) {//外层循环控制排序趟数
			for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
				if (arr[j] > arr[j + 1]){
					swap(arr, j, j + 1);
					flag = false;
					index++;
				}

			};
			if(flag)
				break;
		}
		System.out.println("排序后的数组为："+index+"||"+flag+"||" + Arrays.toString(arr));

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}