package com.mozi.lintcode;

import org.junit.Test;

/**
 * @author :zhouwenbin
 * @time   :18/4/20
 * @comment:
 **/
public class FirstAppearStr {

    @Test
    public void test(){

        System.out.println("第一个只出现一次的串为:"+getFirstAppearStr("google"));
        System.out.println("第一个只出现一次的串为:"+getFirstAppearStr("abc"));
        System.out.println("第一个只出现一次的串为:"+getFirstAppearStr("aabbcc"));
    }

    private String getFirstAppearStr(String str){

        String rtn="#";
        int[] counts=new int[256];

        for(int i=0;i<str.length();i++){

            System.out.println("字符及对应的index:"+str.charAt(i)+",index:"+(int)str.charAt(i));
            counts[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(counts[str.charAt(i)]==1)
                return str.charAt(i)+"";
        }

        return rtn;
    }


}
