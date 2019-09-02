package com.mozi.lintcode.sort;

import java.util.Arrays;

/**
 * @author :zhouwenbin
 * @time   :19/3/12
 * @comment:
 * 方法其实很简单：分别从初始序列“6 1 2 7 9 3 4 5 10 8”两端开始“探测”。
 * 先从右往左找一个小于6的数，再从左往右找一个大于6的数，然后交换他们。
 * 这里可以用两个变量i和j，分别指向序列最左边和最右边。
 * 我们为这两个变量起个好听的名字“哨兵i”和“哨兵j”。
 * 刚开始的时候让哨兵i指向序列的最左边（即i=1），指向数字6。让哨兵j指向序列的最右边（即=10），指向数字。
 **/

public class QuickSort1 {
	public static void quickSort(int[] arr,int left,int right){
		int i,j,temp;
		if(left>right){
			return;
		}
		i=left;
		j=right;
		//temp就是基准位
		temp = arr[left];

		while (i<j) {
			//先看右边，依次往左递减
			while (arr[j]>=temp && j>i) {j--;}
			//再看左边，依次往右递增
			while (arr[i]<=temp && i<j){i++;}
			//如果满足条件则交换
			if (i<j) {
				swap(arr,i,j);
			}
		}

		//最后将基准为与i和j相等位置的数字交换
		arr[left] = arr[i];
		arr[i] = temp;
		//递归调用左半数组
		quickSort(arr, left, j-1);
		//递归调用右半数组
		quickSort(arr, j+1, right);
	}

	private static void swap (int arr [],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args){
		int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
		quickSort(arr, 0, arr.length-1);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println("排序结果：" + Arrays.toString(arr));
	}
}




