package com.mozi.lintcode;

/**
 * @author :zhouwenbin
 * @time   :19/2/21
 * @comment:3+2 3个private,3个static 2个public ,1个final
 * 3pr2pu3sta 3私两公三静
 **/
public class InnerSingle {

	private  InnerSingle(){};

	private static class Inner{
		private final static InnerSingle single=new InnerSingle();
	}

	public static InnerSingle getSingle(){
		return Inner.single;
	}
}
