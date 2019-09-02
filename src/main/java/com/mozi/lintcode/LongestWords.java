package com.mozi.lintcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :18/4/17
 * @comment:
 * Example
Given

{
"dog",
"google",
"facebook",
"internationalization",
"blabla"
}
the longest words are(is) ["internationalization"].

Given

{
"like",
"love",
"hate",
"yes"
}
the longest words are ["like", "love", "hate"].
 **/
public class LongestWords {

    public static void main(String[] args){

        String[] strs =new String[]{"likee","love","hate","yes"};
        List<String> list=LongestWords.getLongestWord(strs);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

   static List<String> getLongestWord(String [] array){

        int maxLen=0;
        for (int i=0;i<array.length;i++){
            if(array[i].length()>maxLen)
                maxLen=array[i].length();
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i].length()==maxLen)
                list.add(array[i]);
        }
        return list;
    }
}
