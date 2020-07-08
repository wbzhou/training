package com.mozi.lintcode.str;

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


方法二：滑动窗口
算法

暴力法非常简单，但它太慢了。那么我们该如何优化它呢？

在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 ii 到 j - 1j−1 之间的子字符串 s_{ij}s
ij
​
已经被检查为没有重复字符。我们只需要检查 s[j]s[j] 对应的字符是否已经存在于子字符串 s_{ij}s
ij
​
中。

要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)O(n
2
) 的算法，但我们可以做得更好。

通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。

滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，
则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。

回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引 jj，
如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。

Java


 */
public class LengthOfLongestNoRepeatSubstring {

    public static void main(String[] args) {


        System.out.println("结果为:"+newSlide("arabcacfr"));
        System.out.println("结果为:"+newSlide("abcabcbb"));
        System.out.println("结果为:"+newSlide("bbbbb"));
        System.out.println("结果为:"+newSlide("pwwkew"));
        System.out.println("结果为:"+newSlide("abba"));
    }

    /**题解二 滑动窗口：
     * 定义一个滑动窗口，记录当前子串的起始位置和结束位置，并将当前子串加入集合中。
     * 每次向集合中添加字符时首先判断该字符是否在集合中已经存在，若存在则滑动窗口区间的起始点向前移动一个位置，
     * 在移动之前将重复字符移除，直至结束。
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
