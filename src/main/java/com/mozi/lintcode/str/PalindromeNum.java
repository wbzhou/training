package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/11/15
 * @comment:
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

 **/
public class PalindromeNum {

	public static void main(String[] args) {



		System.out.println("结果1:"+isPalindRome(-11));
		System.out.println("结果2:"+isPalindRome(11));
		System.out.println("结果2:"+isPalindRome(112));
		System.out.println("结果3:"+isPalindRome(12321));
	}

	public static  boolean isPalindRome(int x){

		if(x<0)
			return false;
		int cur=x;
		int tar=0;
		while (cur>0){
			tar=tar*10+cur%10;
			cur=cur/10;
		}
		return tar==x;
	}

}
