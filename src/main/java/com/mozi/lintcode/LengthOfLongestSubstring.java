package com.mozi.lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: create by junting
 * @version: v1.0
 * @description:
 * @date:2019/9/23
 *
 * 示例一：
输入: “abcabcbb”
输出: 3
解释: 因为无重复字符的最长子串是 “abc”，所以其长度为 3。

示例二：
输入: “bbbbb”
输出: 1
解释: 因为无重复字符的最长子串是 “b”，所以其长度为 1。

示例三：
输入: “pwwkew”
输出: 3
解释: 因为无重复字符的最长子串是 “wke”，所以其长度为 3。
————————————————
版权声明：本文为CSDN博主「鯉鱼」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/hahaeverybody/article/details/89017886
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {


        System.out.println("结果为:"+newSlide("arabcacfr"));
        System.out.println("结果为:"+newSlide("abcabcbb"));
        System.out.println("结果为:"+newSlide("bbbbb"));
        System.out.println("结果为:"+newSlide("pwwkew"));
        System.out.println("结果为:"+newSlide("abba"));
    }

    /**题解二 滑动窗口：
     * 定义一个滑动窗口，记录当前子串的起始位置和结束位置，并将当前子串加入集合中。
     * 每次向集合中添加字符时首先判断该字符是否在集合中已经存在，若存在则滑动窗口区间的起始点向前移动一个位置，在移动之前将重复字符移除，直至结束。
     一步步向前滑，直到集合中不存在该字符时，再将该字符插入集合并更新j
     ————————————————
     * @param s
     * @return
     */
    public static  int lengthOfLongestSubstring(String s) {
        int len=0;
        Set<Character> sub=new HashSet<>();
        int i=0,j=0;
        while(i<s.length()&&j<s.length()) {
            if(sub.contains(s.charAt(j))) {
                sub.remove(s.charAt(i++));
            }else{
                sub.add(s.charAt(j));
                j++;
                len=Math.max(len, j-i);
            }
        }
        return len;
    }


    /**题解二 优化的滑动窗口
     * 是在滑动窗口的基础上，每次滑动窗口区间[i,j)中的i向前移动时移动的位置个数大于等于1。
     定义一个滑动窗口，记录无重复字符的子串的起始位置和结束位置，即[i,j)，将该窗口内的字符以及该字符在数组中的下标存入集合map中，
     新来的字符首先判断map中是否已经存在，若不存在则j加1,并更新无重复子串的长度；反之获取当前字符的位置k，更新i=math.max(k+1,i)，之所以k+1和i取最大，
     是为了防止获取的后一个添加的重复字符的下标比前一个添加的重复字符的下标要小，即字符串为abba这种情况。
     [i,j)区间永远记录无重复的子串，但当前区间并不一定对应的是最长的无重复子串。
     （子串，不重复，区间，跳跃）
     跳跃式的滑动，当前更新后的i到j之间不存在与将插入的字符重复的元素。
     ————————————————
     版权声明：本文为CSDN博主「鯉鱼」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/hahaeverybody/article/details/89017886



     ————————————————
     * @param s
     * @return
     */
    public static  int newSlide(String s) {
        int len=0;
        Map<Character,Integer> windowMap=new HashMap<>();
        int i=0,j=0;
        while(i<s.length()&&j<s.length()) {
            if(windowMap.containsKey(s.charAt(j))) {
                //应该保证滑动窗口的起始位置依次向前，不能倒退
                i=Math.max(i, windowMap.get(s.charAt(j))+1);//Math.max的作用 ：考虑字符串abba这个例子
            }
            windowMap.put(s.charAt(j), j);
            j++;
            len=Math.max(len, j-i);

        }
        return len;
    }
}
