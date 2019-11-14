package com.mozi.lintcode.str;

/**
 * @author :zhouwenbin
 * @time   :19/11/12
 * @comment:
 **/
public class ReverseStr {
	public static void main(String[] args) {

		String str="A man, a plan, a canal: Panama";

		String twoRes=reverseString(str.toCharArray());

		String rev="";
		for(int i=str.length()-1;i>=0;i--){
			rev+=str.charAt(i);
		}
		System.out.println("结果1:"+rev);
		System.out.println("结果2:"+twoRes);
		System.out.println("结果3:"+forReverse(str.toCharArray()));
	}


	public static String forReverse(char[] s) {
		int sLength=s.length;
		char temp;
		for(int i=0,j=sLength-1;i<j;i++,j--){
			temp=s[i];
			s[i]=s[j];
			s[j]=temp;
		}
		return String.valueOf(s);
	}


	public static  String reverseString(char[] s) {
		if (s == null || s.length < 2) {
			return s.toString();
		}
		int left = -1;
		int right = s.length;
		while (++left < --right) {
			char c = s[left];
			s[left] = s[right];
			s[right] = c;
		}

		return String.valueOf(s);
	}

}
