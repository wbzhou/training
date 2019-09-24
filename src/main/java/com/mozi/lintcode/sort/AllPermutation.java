package com.mozi.lintcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author :zhouwenbin
 * @time   :19/9/24
 * @comment:
 * 字符串的排列（全排列）——Java、回溯法
 * https://blog.csdn.net/Strom72/article/details/80738818
 **/
public class AllPermutation {



	public static void main(String[] args) {
		String str="abc";
		ArrayList<String> strList = permutation(str);
		System.out.println("全排序后的数组为："+strList);

	}


	public static ArrayList<String> permutation(String str) {
		ArrayList<String> ans = new ArrayList<>();//所有排列的可能都在这里
		if (str != null || str.length() > 0) {
			help(0, str.toCharArray(), ans);
			Collections.sort(ans);
		}

		return ans;
	}

	public static void help(int i, char[] cha, ArrayList<String> ans) {
		if (i == cha.length - 1) {
			String val = String.valueOf(cha);
			if (!ans.contains(val)) {
				ans.add(val);
			}
		} else {
			for (int j = i; j < cha.length; j++) {
				swap(i, j, cha);//依次选一个数固定住
				help(i + 1, cha, ans);//让后面的进行全排列
				swap(i, j, cha);//恢复原来的模样，回溯关键
			}
		}

	}

	public static void swap(int i, int j, char[] cha) {
		char temp = cha[i];
		cha[i] = cha[j];
		cha[j] = temp;

	}

}