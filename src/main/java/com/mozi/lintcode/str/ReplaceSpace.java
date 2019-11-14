package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/11/14
 * @comment:
 **/
public class ReplaceSpace {

	public static void main(String[] args) {
		ReplaceSpace main = new ReplaceSpace();
		StringBuffer s =new StringBuffer("We Are Happy");
		System.out.println(main.replaceSpace(s));

	}

	/**
	 * 思路：
	 * 1.计算出字符串长度（old_len + (space_len * 2)）
	 * 2.从新长度的最后一位往前放置字符串内容，保证元素一次到达自己的位置
	 *
	 * 时间复杂度：O（n）
	 * @param str
	 * @return
	 */
	public String replaceSpace(StringBuffer str) {
		//原本长度
		int old_len = str.length();
		//空格长度
		int space_len = 0;
		for (int i = 0; i < old_len; i++) {
			if (str.charAt(i) == ' ') {
				space_len++;
			}
		}
		//设置新字符串长度
		int new_len = old_len + (space_len * 2);
		str.setLength(new_len);

		//从最后一位往前移动
		int index_old = old_len - 1;//原字符串索引
		int index_new = new_len - 1;//新字符串索引
		while (index_new >=0) {
			//若该位置为空格
			if (str.charAt(index_old) == ' ') {
				str.setCharAt(index_new--, '0');
				str.setCharAt(index_new--, '2');
				str.setCharAt(index_new--, '%');
			}
			//否则该位置不为空格
			else {
				str.setCharAt(index_new--, str.charAt(index_old));
			}
			index_old--;
		}
		return str.toString();
	}
}
