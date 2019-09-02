package base.learn.thread;

/**
@author :zhouwenbin
@time   :2018年1月6日
@comment:
**/
public class ThreadOne extends Thread{

	private Order order;

	ThreadOne(Order order) {
		this.order=order;
	}
	
	public void run() {
		order.setVersion(order.getVersion()+1);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
