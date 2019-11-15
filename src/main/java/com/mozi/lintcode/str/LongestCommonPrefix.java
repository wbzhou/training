package com.mozi.lintcode.str;

import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :19/11/15
 * @comment:
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:
	 **/
public class LongestCommonPrefix {

	public static void main(String[] args){

		String[] strs =new String[]{"flower","flow","flight"};
		System.out.println("返回:"+longestCommonPrefix(strs));

	}


	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";
			}
		return prefix;
	}

}
