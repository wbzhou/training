package com.mozi.lintcode.LinkNode;

import base.learn.vo.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :zhouwenbin
 * @time   :20/3/12
 * @comment:
 *
 * 方法一：栈
栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置。从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。

创建一个栈，用于存储链表的节点
创建一个指针，初始时指向链表的头节点
当指针指向的元素非空时，重复下列操作：
将指针指向的节点压入栈内
将指针移到当前节点的下一个节点
获得栈的大小 size，创建一个数组 print，其大小为 size
创建下标并初始化 index = 0
重复 size 次下列操作：
从栈内弹出一个节点，将该节点的值存到 print[index]
将 index 的值加 1
返回 print

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class ReversePrintNode {

	public int[] reversePrint(ListNode head) {
//		Stack<ListNode> stack = new Stack<ListNode>();
//		ListNode temp = head;
//		while (temp != null) {
//			stack.push(temp);
//			temp = temp.next;
//		}
//		int size = stack.size();
//		int[] print = new int[size];
//		for (int i = 0; i < size; i++) {
//			print[i] = stack.pop().getData();
//		}
//		return print;

		ListNode newHead=reverseList(head);
		List<Integer> list =new ArrayList<>();
		while(newHead!=null){
			list.add(newHead.getData());
			newHead=newHead.next;
		}
		return list.stream().mapToInt(Integer::valueOf).toArray();
	}


	public ListNode reverseList(ListNode head) {
		ListNode pre=null;
		ListNode curNode=head;
		while(curNode!=null){
			ListNode nextNode=curNode.next;
			curNode.next=pre;
			pre=curNode;
			curNode=nextNode;
		}
		return pre;

	}

}
