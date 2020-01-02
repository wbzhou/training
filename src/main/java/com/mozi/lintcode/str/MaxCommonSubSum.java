package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/9/2
 * @comment:最长公共子序列 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class MaxCommonSubSum {

	public static void main(String[] args) {

		String text1 = "abcde";
		String text2 = "ace";

		int maxLong = longestCommonSubsequence(text1, text2);
		System.out.println("最长公共子序列:" + maxLong);
	}

	public static  int longestCommonSubsequence(String text1, String text2) {
		int[][] dip = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <=text1.length(); j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					dip[i][j] = dip[i - 1][j - 1] + 1;
				else
					dip[i][j] = Math.max(dip[i - 1][j], dip[i][j - 1]);
			}
		}
		return dip[text1.length()][text2.length()];
	}


}
