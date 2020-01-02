package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/11/15
 * @comment:
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 **/
public class PalindromeStr	 {


	public static void main(String[] args) {



		System.out.println("结果1:"+isPalindrome("race a car"));
		System.out.println("结果2:"+isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("结果2:"+isPalindrome("aa"));
	}

	public static  boolean isPalindrome(String s) {
		if(s.length() == 0)
			return true;
		int l = 0, r = s.length() - 1;
//		while(l<r)
		while(l < r){
			if(!Character.isLetterOrDigit(s.charAt(l))){
				l++;
			}else if(!Character.isLetterOrDigit(s.charAt(r))){
				r--;
			}else{
				if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
					return false;
				l++;
				r--;
			}
		}
		return true;
	}
}
