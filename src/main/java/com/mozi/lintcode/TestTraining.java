package com.mozi.lintcode;

import base.learn.classload.TestUser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author :zhouwenbin
 * @time   :19/11/5
 * @comment:
 **/
public class TestTraining {

	Semaphore sema4h = new Semaphore(2);
	Semaphore sema4o = new Semaphore(1);
	AtomicInteger hcount = new AtomicInteger(0);

	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool();


	}

	public static boolean checkStrIsNum(String str) {
		try {
			if(StringUtils.isBlank(str))
				return false;
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
		} catch (Exception e) {
			return true;
		}

		return true;
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		try {
			sema4h.acquire();
			releaseHydrogen.run();
			if (hcount.incrementAndGet() % 2==0)
				sema4o.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		try {
			sema4o.acquire();
			releaseOxygen.run();
			sema4h.release(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static boolean isValid(String s) {
//		System.out.println("得到的值:"+isValid("{[]}"));

//		初始化栈 S。
//		一次处理表达式的每个括号。
//		如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
//		如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
//		如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
//
//		作者：LeetCode
//		链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// If the current character is a closing bracket.
			if (map.containsKey(c)) {
				// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
				char topElement = stack.empty() ? '#' : stack.pop();

				// If the mapping for this bracket doesn't match the stack's top element, return false.
				if (topElement != map.get(c)) {
					return false;
				}
			} else {
				// If it was an opening bracket, push to the stack.
				stack.push(c);
			}
		}

		// If the stack still contains elements, then it is an invalid expression.
		return stack.isEmpty();

	}



	public static String reverse2(String str) {
//		String str="A man, a plan, a canal: Panama";
		char[] chars = str.toCharArray();
		String reverse = "";
		for (int i = chars.length - 1; i >= 0; i--) {
			reverse += chars[i];
		}
		return reverse;
	}

	public  static  int geNum(int n){
		n+=1;
		try {
			int i=n/0;
		} catch (Exception e) {
			n++;
		}
		n++;
		return ++n;
	}


	public static Node reverse(Node curNode){
		Node preNode=null;
		while (curNode.next!=null){
			Node nextNode=curNode.next;
			curNode.next=preNode;
			preNode=curNode;
			curNode=nextNode;
		}
		return preNode;
	}

}
