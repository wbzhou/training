package com.mozi.lintcode.sort;

import java.util.Arrays;

/**
 * @author :zhouwenbin
 * @time   :19/7/29
 * @comment:
 **/
public class QuickTopK {

	public static int  quickSort(int[] arr,int k,int left,int right){
		int i=left;
		int j=right;
		//temp就是基准位
		int temp = arr[left];

		while (i<j) {
			//先看右边，依次往左递减
			while (arr[j]<=temp && j>i) {j--;}
			//再看左边，依次往右递增
			while (arr[i]>=temp && i<j){i++;}
			//如果满足条件则交换
			if (i<j) {
				swap(arr,i,j);
			}
		}
		//最后将基准为与i和j相等位置的数字交换
		arr[left] = arr[i];
		arr[i] = temp;

		if(j==k-1)
//		   return temp;
		   return arr[j];
		else if(j>k-1){
			return quickSort(arr,k, left, j-1);//递归调用左半数组
		}else{
			return quickSort(arr,k, j+1, right);//递归调用右半数组
		}

	}



	public static void main(String[] args){
		int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
		System.out.println("第k大的数为:"+quickSort(arr, 4, 0, arr.length - 1));
		System.out.println("排序结果：" + Arrays.toString(arr));


	}

	private static void swap (int arr [],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
