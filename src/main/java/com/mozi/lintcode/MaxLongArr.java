package com.mozi.lintcode;

/**
 * @author :zhouwenbin
 * @time   :19/9/2
 * @comment:动态规划法
 **/
public class MaxLongArr {

	public static void main(String[] args){

		int arr[]={-2,1,-3,4,-1,2,1,-5,4};

		int maxLong=getMaxLongStr(arr);
		System.out.println("最大的子字串的和:"+maxLong);
	}
	public static  int getMaxLongStr(int[] arr){

		int[] dip=new int[arr.length];
		int max=dip[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			if(dip[i-1]+arr[i]>arr[i])
				dip[i]=dip[i-1]+arr[i];
			else
				dip[i]=arr[i];
			if(max<dip[i])
				max=dip[i];

		}
		return max;
	}


}
