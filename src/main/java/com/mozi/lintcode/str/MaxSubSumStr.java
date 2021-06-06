package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/9/2
 * @comment:动态规划法
 * 最大字序列和
 **/
public class MaxSubSumStr {

	public static void main(String[] args){

		int arr[]={-2,1,-3,4,-1,2,1,-5,4};

		int maxLong=getMaxLongStr(arr);
		System.out.println("最大的子字串的和:"+maxLong);
		System.out.println("最大的子字串的和:"+getMaxLongStr2(arr));
	}
	public static  int getMaxLongStr(int[] arr){

		int[] dip=new int[arr.length];
		int max=dip[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			if(dip[i-1]+arr[i]>arr[i])//(ddi-1x)
				dip[i]=dip[i-1]+arr[i];
			else
				dip[i]=arr[i];
			if(max<dip[i])
				max=dip[i];

		}
		return max;
	}


	public static  int getMaxLongStr2(int[] arr){

		int result=Integer.MIN_VALUE;
		int sum=0;
		for(int tmp :  arr){
			sum+=tmp;
			if(sum>result)
				result=sum;
			if(sum<=0){
				sum=0;
			}
		}
		return result;
	}
//贪心解法
//贪心贪的是哪里呢？
//
//如果 -2 1 在一起，计算起点的时候，一定是从1开始计算，因为负数只会拉低总和，这就是贪心贪的地方！
//
//局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
//
//全局最优：选取最大“连续和”
//
//局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。
//
//从代码角度上来讲：遍历nums，从头开始用count累积，如果count一旦加上nums[i]变为负数，那么就应该从nums[i+1]开始从0累积count了，因为已经变为负数的count，只会拖累总和。
//
//这相当于是暴力解法中的不断调整最大子序和区间的起始位置。
//
//那有同学问了，区间终止位置不用调整么？ 如何才能得到最大“连续和”呢？
//
//区间的终止位置，其实就是如果count取到最大值了，及时记录下来了。例如如下代码：
//
//
//if (count > result) result = count;
//这样相当于是用result记录最大子序和区间和（变相的算是调整了终止位置）。
//
//如动画所示：
//
//作者：carlsun-2
//链接：https://leetcode-cn.com/problems/maximum-subarray/solution/53-zui-da-zi-xu-he-bao-li-tan-xin-xiang-jie-by-car/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//	class Solution {
//		public:
//		int maxSubArray(vector<int>& nums) {
//			int result = INT32_MIN;
//			int count = 0;
//			for (int i = 0; i < nums.size(); i++) {
//				count += nums[i];
//				if (count > result) { // 取区间累计的最大值（相当于不断确定最大子序终止位置）
//					result = count;
//				}
//				if (count <= 0) count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
//			}
//			return result;
//		}
//	};
//
//	作者：carlsun-2
//	链接：https://leetcode-cn.com/problems/maximum-subarray/solution/53-zui-da-zi-xu-he-bao-li-tan-xin-xiang-jie-by-car/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}