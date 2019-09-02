package com.mozi.lintcode.sort;

import java.util.Arrays;

/**
 * @author :zhouwenbin
 * @time   :19/3/25
 * @comment:
 **/
public class ZQuickTest {

	public static void main(String[] args){
		int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
		quickSort(arr, 0, arr.length-1);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println("排序结果：" + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left>right)
			return;
		int i=left;
		int j=right;
		int temp=arr[left];

		while(i<j){
			while(arr[j]>=temp&&j>i){j--;}
			while(arr[i]<=temp&&i<j){i++;}
			if(i<j)
				swap(arr,i,j);
		}
		//i,j相等了
		arr[left]=arr[i];
		arr[i]=temp;
		quickSort(arr,left,j-1);
		quickSort(arr,j+1,right);


	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}


}
