package com.mozi.lintcode.XiePrintArray;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :19/11/29
 * @comment:
 * 给定一个矩阵 A， 返回 A 的转置矩阵。

矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

 

示例 1：

输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]
示例 2：

输入：[[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]

1 2 3
4 5 6

-->

1 4
2 5
3 6
 
 **/
public class AtMatrix {


	public  static  void main(String[] args){

		int[][] newMatris=new int[][]{{1,2,3},{4,5,6}};

		int[][] transpose = transpose(newMatris);

		System.out.println("最后输出的小矩阵:"+JSONObject.toJSONString(transpose));


	}


	public static  int[][] transpose(int[][] A) {
		int R = A.length, C = A[0].length;
		int[][] ans = new int[C][R];
		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c) {
				ans[c][r] = A[r][c];
			}
		return ans;
	}



}
