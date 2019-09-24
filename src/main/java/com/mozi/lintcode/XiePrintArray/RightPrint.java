package com.mozi.lintcode.XiePrintArray;

/**
 * @author :zhouwenbin
 * @time   :19/9/3
 * @comment:
 * 其中的题目要求如下：

二维数组（N*N），沿对角线方向，从右上角打印到左下角如N=4：
4*4二维数组

Java代码   收藏代码
{ 1  2  3  4 }
{ 5  6  7  8 }
{ 9 10 11 12 }
{13 14 15 16 }

打印顺序

Java代码   收藏代码
4
3 8
2 7 12
1 6 11 16
5 10 15
9 14
13

要求半个小时内写出可完整运行的代码。



由于本人算法也不太好，找出其中的大概规律如下，以（i，j）作为坐标轴打印结果：

Java代码  收藏代码
（0，3）
（0，2）（1，3）
（0，1）（1，2）（2，3）
（0，0）（1，1）（2，2）（3，3）
（1，0）（2，1）（3，2）
（2，0）（3，1）
（3，0）


于是大致分析出其中的规律，写出以下算法程序
第一层循环中，设置矩阵输出的起始坐标，起始坐标的基本规律是，列index如果不为0，下一行中列index--;列index为0，下一行中行index++。

第二层循环中，对于起始的坐标，在没有到达最后一列时，坐标的行列index均++。
 **/
public class RightPrint {

	private static final int[][] DATA = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

	public static void main(String[] args) {
		int n = DATA.length;
		int iStart = 0;
		int jStart = n - 1;

		while (iStart != n) {
			for (int i = iStart, j = jStart; i <= n - 1 && j <= n - 1; i++, j++) {
				System.out.print(DATA[i][j]);
				System.out.print(" ");
			}
			if (jStart > 0) {
				jStart--;
			} else {
				iStart++;
			}
			System.out.println();
		}

	}
}
