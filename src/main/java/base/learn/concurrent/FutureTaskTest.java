package base.learn.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Callable<String> task = new Callable<String>() {
			public String call() {
				System.out.println("Sleep start.");
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Sleep end.");
				return "我是结果";	
			}
		};
		
//		//直接使用Thread的方式执行
//		FutureTask<String> ft = new FutureTask<String>(task);
//		Thread t = new Thread(ft);
//		t.start();
//		try {
//			System.out.println("waiting execute result");
//			System.out.println("result = " + ft.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		//使用Executors来执行
		System.out.println("=========");
		FutureTask<String> ft2 = new FutureTask<String>(task);
		Executors.newSingleThreadExecutor().submit(ft2);
		try {
			System.out.println("waiting execute result");
			System.out.println("result = " + ft2.isDone());
			Thread.sleep(1000 * 8);
			System.out.println("result最后 = " + ft2.isDone()+","+ft2.get());
			System.out.println("跑后面的东西"+ft2.isDone()+","+ft2.isCancelled());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}