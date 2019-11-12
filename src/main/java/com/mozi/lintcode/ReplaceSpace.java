package com.mozi.lintcode;

import java.util.Arrays;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2019/10/13
 *
 * 　请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。

回到顶部
思路
　　首先要询问面试官是新建一个字符串还是在原有的字符串上修改，本题要求在原有字符串上进行修改。

　　若从前往后依次替换，在每次遇到空格字符时，都需要移动后面O(n)个字符，对于含有O(n)个空格字符的字符串而言，总的时间效率为O(n2)。

　　转变思路：先计算出需要的总长度，然后从后往前进行复制和替换，，则每个字符只需要复制一次即可。时间效率为O(n)。

测试用例

　　1.字符串中无空格

　　2.字符串中含有空格（连续空格，空格在首尾等）

　　3.字符串为空字符串或者为null

https://www.cnblogs.com/yongh/p/9328270.html
 */
public class ReplaceSpace {

    public static void main(String[] args) {


        String str="We are happy";
        System.out.println("最后返回:"+replaceSpace(str));

        String[] arr=new String[]{"flower","flow","flight"};
        System.out.println("最长公共子串为:"+longestCommonPrefix(arr));

    }

    public  static String replaceSpace(String str){

        StringBuffer buffer=new StringBuffer();
        int length=str.length();
        for(int i=0;i<length;i++){
            if(str.charAt(i)==' ')
                buffer.append("%20");
            else
                buffer.append(str.charAt(i));
        }
        return buffer.toString();

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray();
        char [] last = strs[strs.length - 1].toCharArray();
        StringBuffer res = new StringBuffer();
        int len = first.length < last.length ? first.length : last.length;
        int i = 0;
        while(i < len){
            if(first[i] == last[i]){
                res.append(first[i]);
                i++;
            }
            else
                break;
        }
        return res.toString();
    }
}
