package com.mozi.lintcode.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :zhouwenbin
 * @time   :19/9/5
 * @comment:
 **/
public class LinkedHashMapTest {

	public static void main(String[] args){
//		LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
//		map.put("1月", 20);
////此时就会调用到linkNodeLast()方法，也会调用afterNodeAccess()方法，但会被阻挡在
////if (accessOrder && (last = tail) != e) 之外
//		map.put("2月", 30);
//		map.put("3月", 65);
//		map.put("4月", 43);
////这时不会调用linkNodeLast()，会调用afterNodeAccess()方法将key为“1月”的元素放到最后
//		map.put("1月", 35);
////这时不会调用linkNodeLast()，会调用afterNodeAccess()方法将key为“2月”的元素放到最后
//		map.get("2月");
////调用打印方法
//		for (Map.Entry<String, Integer> entry : map.entrySet()){
//			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
//		}



		LinkedHashMap<String, Integer> sortMap = new LinkedHashMap<>(16, 0.75f, false);
		sortMap.put("1月", 20);
//此时就会调用到linkNodeLast()方法，也会调用afterNodeAccess()方法，但会被阻挡在
//if (accessOrder && (last = tail) != e) 之外
		sortMap.put("2月", 30);
		sortMap.put("3月", 65);
		sortMap.put("4月", 43);
//这时不会调用linkNodeLast()，会调用afterNodeAccess()方法将key为“1月”的元素放到最后
		sortMap.put("1月", 35);
		sortMap.get("2月");
//调用打印方法
		for (Map.Entry<String, Integer> entry : sortMap.entrySet()){
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}




}
