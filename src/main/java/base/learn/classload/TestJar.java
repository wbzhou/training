package base.learn.classload;

import java.util.LinkedHashMap;
import java.util.Map;

/**
@author :zhouwenbin
@time   :2017年12月13日
@comment:
如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
如果accessOrder为flase的话，则按插入顺序来遍历
**/
public class TestJar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, false);
		map.put("1月", 20);
//此时就会调用到linkNodeLast()方法，也会调用afterNodeAccess()方法，但会被阻挡在
//if (accessOrder && (last = tail) != e) 之外
		map.put("2月", 30);
		map.put("3月", 65);
		map.put("4月", 43);
//这时不会调用linkNodeLast()，会调用afterNodeAccess()方法将key为“1月”的元素放到最后
		map.put("1月", 35);
//这时不会调用linkNodeLast()，会调用afterNodeAccess()方法将key为“2月”的元素放到最后
		map.get("2月");
//调用打印方法
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}

}
