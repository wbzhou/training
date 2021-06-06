package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/11/15
 * @comment: 求最长回文子串
 *
 * 我们创建一个二维数组，boolean[][]dp,其中dp[i][j]表示字符串第i到j是否为回文。那么边界值其实很清楚了，
 * j-i=1的都为true 字符串长度为1的都为true。状态转换如何设定呢？当字符串i所在的字符等于字符串j所在的字符
 * ，并且它的内部(dp[i+1][j-1])为回文那么dp[i][j]为true。
 * 因为这样的规律，我们要保证判断dp[i][j]的时候dp[i+1][j-1]已经判断，所以我们遍历采用i降序j升序的嵌套遍历的方式


DP

动态规划的方法，我会在下一篇单独来介绍，这里只说明此题的DP代码

对于字符串str，假设dp[i,j]=1表示str[i...j]是回文子串，
那个必定存在dp[i+1,j-1]=1。这样最长回文子串就能分解成一系列子问题，可以利用动态规划求解了。首先构造状态转移方程



上面的状态转移方程表示，当str[i]=str[j]时，如果str[i+1...j-1]是回文串，
则str[i...j]也是回文串；如果str[i+1...j-1]不是回文串，则str[i...j]不是回文串。

初始状态

dp[i][i]=1
dp[i][i+1]=1 if str[i]==str[i+1]
上式的意义是单个字符，两个相同字符都是回文串。
 **/
public class LongestPalindromeSubStr {

	public static void main(String[] args) {



//		System.out.println("结果1:"+longestPalindrome("a"));
		System.out.println("结果1:"+longestPalindrome("abcdee"));
//		System.out.println("结果1:"+longestPalindrome("aba"));
		System.out.println("结果1:"+longestPalindrome("abcdcba"));
		System.out.println("结果1:"+longestPalindrome("abccccdd"));
		System.out.println("结果1:"+longSize("abccccdd"));
	}
	public static String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return s;
		}
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int left = 0;
		int right = 0;
		for (int i = n - 2; i >= 0; i--) {
			dp[i][i] = true;
			for (int j = i + 1; j < n; j++) {
				System.out.println(dp[i+1][j-1]);
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
				if (dp[i][j] && right - left < j - i) {
					left = i;
					right = j;
				}
			}
		}
		return s.substring(left, right + 1);
	}

		public static int longSize(String s) {
			if (s.isEmpty()) {
				return 0;
			}
			int n = s.length();
			boolean[][] dp = new boolean[n][n];
			int left = 0;
			int right = 0;
			for (int i = n - 2; i >= 0; i--) {
				dp[i][i] = true;
				for (int j = i + 1; j < n; j++) {
					dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
					if (dp[i][j] && right - left < j - i) {
						left = i;
						right = j;
					}
				}
			}
			return right-left+1;
		}

}
