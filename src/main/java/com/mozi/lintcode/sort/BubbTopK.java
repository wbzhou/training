package com.mozi.lintcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author :zhouwenbin
 * @time   :19/7/29
 * @comment:O(n*k)
 **/
public class BubbTopK {


	public static void main(String ar[]) {
		int[] arr = {10, 8, 2, 4, 7, 3, 3, 4};
		int kbig = findKbig(arr, 4);
		System.out.println("第k大的数为:" + kbig);
		System.out.println("第5大的数为:" + findKbig(arr, 5));
		System.out.println("第6大的数为:" + findKbig(arr, 6));
		System.out.println("第7大的数为:" + findKbig(arr, 7));
	}

	private static int findKbig(int arr[], int k) {
		for (int i = 0; i < arr.length&&i<k; i++) {//外层循环控制排序趟数
			for (int j = 0; j < arr.length - 1 - i; j++) {//经过第i次比较后,可产生第i大或第i小的数,在最前面
				if (arr[j] < arr[j + 1]){
					swap(arr, j, j + 1);
				}

			}
		}
		return arr[k-1];
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
