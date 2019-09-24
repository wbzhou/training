package com.mozi.lintcode.XiePrintArray;

/**
 * @author :zhouwenbin
 * @time   :19/9/3
 * @comment:
 **/
public class LeftPrint {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] rectangle = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
//				{1,2,3,4,5},
		};

//		1     //00
//		2 4   //01,10
//		3 5 7 //02,11,20
//		6 8   //12,21
//		9     //22


		System.out.println("数据的长度:"+ rectangle.length);
		System.out.println("数据0的长度:"+ rectangle[0].length);

		printRectangle(rectangle, rectangle.length);
	}

	public static void printRectangle(int[][] a,int n) {
		int j = 0;

		for(int num = 0 ;num <2*n;num++) {

			for(int i = 0;i < n ;i++) {

				j = num - i;

				if((j >= 0) && (j < n)) {

					System.out.print(a[i][j]+" ");
				}
			}

			System.out.println();
		}
	}

}
