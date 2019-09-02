package com.mozi.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author :zhouwenbin
 * @time   :19/8/24
 * @comment:https://www.cnblogs.com/szlbm/p/5588555.html 简单实现一个加权的负载均衡算法
 **/
public class LVS {

	private static Integer pos = 0;
	private static HashMap<String, Integer> ipMap = new HashMap() {
	};

	static {
		ipMap.put("1.1.1.1", 1);
		ipMap.put("1.1.1.2", 5);
		ipMap.put("1.1.1.3", 4);
		ipMap.put("1.1.1.4", 1);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			System.out.println("访问的服务器为:" + LVS.getServer());
		}

	}

	private static String getServer() {
		ArrayList<String> keyList = new ArrayList<String>();
//		keyList.addAll(ipMap.keySet());//这是不加权时候的做法;
		Iterator<String> iterator = ipMap.keySet().iterator();
		while (iterator.hasNext()) {//这个循环就是处理加权的
			String server = iterator.next();

			int weight = ipMap.get(server);
			for (int i = 0; i < weight; i++) {
				keyList.add(server);
			}
		}

		String rtnServer = null;
		synchronized (pos) {

			if (pos >= keyList.size())
				pos = 0;
			rtnServer = keyList.get(pos);
			pos++;
		}
		return rtnServer;

	}


}
