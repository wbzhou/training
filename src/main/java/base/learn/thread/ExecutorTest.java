package base.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
@author :zhouwenbin
@time   :2018年1月6日
@comment:
**/
public class ExecutorTest {
	private static ExecutorService exec = Executors.newCachedThreadPool();//以后可考虑写在静态

	public static void main(String[] args) {
		try {
			List<Order> list=getTestOrderList();
			for(int i=0;i<10;i++){
				exec.execute(new ThreadOne(new Order()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Order> getTestOrderList() {
		List<Order> list=new ArrayList<Order>();
		Order orderOne=new Order();
		Order orderTwo=new Order();
		orderOne.setOrderid("11");
		orderOne.setVersion(1);
		orderTwo.setOrderid("22");
		orderTwo.setVersion(1);
		list.add(orderOne);
		list.add(orderTwo);
		return list;
	}
}
