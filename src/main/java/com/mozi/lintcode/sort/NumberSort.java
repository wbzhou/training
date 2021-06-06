package com.mozi.lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :2021/3/16
 * @comment:
 **/
public class NumberSort {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 8};
		int[] arr2 = {1, 4, 5, 6, 9, 10};
		final List list1 = numberSor(arr);
		final List list2 = numberSor(arr2);
		System.out.println("排序结果：" + list1);
		System.out.println("排序结果：" + list2);
	}

	public static List numberSor(int[] arr) {

		List<String> list = new ArrayList<>();
		int min = arr[0], max = arr[0];
		int i=0,j=0;

		while (i < arr.length ) {
			 j = i + 1;
			if (j >=arr.length)
				j = i;
			if (arr[i] +1== arr[j] ) {
				max = arr[j];
				i = j;
			} else {
				if (min == max)
					list.add(min + "");
				else
					list.add(min + "->" + max);
				i ++;
				if (i < arr.length)
					min =max= arr[i];
			}
		}
		return list;

	}
}
