package com.mozi.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhouwenbin
 * @time   :19/2/12
 * @comment:
 **/
public class RedPackage {

	private static final float MINMONEY = 0.01f;
	private static final float MAXMONEY = 200f;
	private static final float TIMES = 2.1f;//每个红包最大的金额为平均金额的Times 倍

	public static void main(String[] args) {
		RedPackage util = new RedPackage();
		System.out.println(util.splitRedPackets(100,50));
	}

	public List<Float> splitRedPackets(float money, int count)
	{
		if(!isRight(money,count))
		{
			return null;
		}
		List<Float> list = new ArrayList<Float>();
		float max = (float)(money*TIMES/count);////每个红包最大的金额为平均金额的Times 倍

		max = max>MAXMONEY?MAXMONEY:max;
		for(int i=0;i<count;i++)
		{
			float one = randomRedPacket(money,MINMONEY,max,count-i);
			list.add(one);
			money-=one;
		}
		return list;
	}


	private float randomRedPacket(float money,float mins,float maxs,int count)
	{
		if(count==1)
		{
			return (float)(Math.round(money*100))/100;
		}
		if(mins == maxs)
		{
			return mins;//如果最大值和最小值一样，就返回mins
		}
		float max = maxs>money?money:maxs;
		float one = ((float)Math.random()*(max-mins)+mins);// //随机一个红包 = 随机一个数* (金额-最小)+最小
		one = (float)(Math.round(one*100))/100;
		float moneyOther = money - one; //剩下的金额
		if(isRight(moneyOther,count-1))// //校验这种随机方案是否可行，不合法的话，就要重新分配方案
		{
			return one;
		}
		else{
			//重新分配
			float avg = moneyOther / (count-1);
			if(avg<MINMONEY)
			{
				return randomRedPacket(money,mins,one,count);
			}else if(avg>MAXMONEY)
			{
				return randomRedPacket(money,one,maxs,count);
			}
		}
		return one;
	}

	private boolean isRight(float money,int count)
	{
		double avg = money/count;
		if(avg<MINMONEY){
			return false;
		}
		else if(avg>MAXMONEY)
		{
			return false;
		}
		return true;
	}
}
