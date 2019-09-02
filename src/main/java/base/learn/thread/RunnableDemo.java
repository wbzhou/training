package base.learn.thread;
/**
@author :zhouwenbin
@time   :2018年1月7日
@comment:
**/
public class RunnableDemo {
	

	public static void main(String[] args) {              
	       // TODO Auto-generated method stub             
	       //设计三个线程       
		MyThread1 mt =new MyThread1();
	        Thread t1 = new Thread(mt,"一号窗口");            
	        Thread t2 = new Thread(mt,"二号窗口");            
	        Thread t3 = new Thread(mt,"三号窗口");            
	//         MyThread1 mt2 = new MyThread1();            
	//        MyThread1 mt3 = new MyThread1();            
	        t1.start();                                   
	        t2.start();                                   
	        t3.start();                                   
	   }                                                  
	                                                                                                             

}
