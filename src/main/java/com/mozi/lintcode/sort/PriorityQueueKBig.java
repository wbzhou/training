package com.mozi.lintcode.sort;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

import java.util.PriorityQueue;

/**
 * @author :zhouwenbin
 * @time   :19/7/26
 * @comment:基于小顶堆排序,保持堆顶元素为当前堆的最小值
 * O(nlogk)
 **/
public class PriorityQueueKBig {
	private static int findKbig(int num[], int k) {
		PriorityQueue<Integer> pque = new PriorityQueue<>();
		for (int entry : num) {
			pque.add(entry);
			if (pque.size() > k) {//堆大小保持为k
				pque.poll();//如果比k大,则把k+1个元素中的最小值poll出去
				//并让剩下的元素以最小堆的形式重新排好序
			}
		}
		return pque.peek();
	}

	public static void main(String ar[]) {
		int[] arr = {10, 8, 2, 4, 7, 3, 3, 4};
		int kbig = findKbig(arr, 3);
		System.out.println("第k大的数为:" + kbig);
	}


}
