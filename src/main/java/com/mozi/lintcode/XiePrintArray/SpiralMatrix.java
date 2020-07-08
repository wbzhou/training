package com.mozi.lintcode.XiePrintArray;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :19/11/28
 * @comment:
 * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]


给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
[1, 2, 3, 4],
[5, 6, 7, 8],
[9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

 **/
public class SpiralMatrix {

	public  static  void main(String[] args){
		int[][] ints = generateMatrix(3);//构建螺旋矩阵
		System.out.println(JSONObject.toJSONString(ints));

		int[][] newMatris=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> integers = spiralOrderOut(newMatris);//螺旋输出这个矩阵


		System.out.println("最后输出的小矩阵:"+JSONObject.toJSONString(integers));
	}


	/**
	 *
	 * 生成一个 n×n 空矩阵 mat，随后模拟整个向内环绕的填入过程：
	 定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
	 当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
	 执行 num += 1：得到下一个需要填入的数字；
	 更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
	 使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。

	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {//trbl(==trouble记忆)
		int l = 0, r = n - 1, t = 0, b = n - 1;
		int[][] mat = new int[n][n];
		int num = 1, tar = n * n;
		while(num <= tar){
			for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
			t++;
			for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
			r--;
			for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
			b--;
			for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
			l++;
		}
		return mat;
	}


	public static	List< Integer > spiralOrderOut(int[][] matrix) {
		List ans = new ArrayList();
		if (matrix.length == 0)
			return ans;
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {//记忆crcr ++--
			for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
			for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
				for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return ans;
	}


}
