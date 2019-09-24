package base.learn.concurrent;

/**
 * @author :zhouwenbin
 * @time   :19/9/17
 * @comment:
 **/
public class TwoThreadPrint {
	volatile static boolean open=false;
	volatile static int index=0;
	static String s="adasdfsafwfvgs";
	static Object ob=new Object();
	static Thread t1=new Thread(new myRun1(),"线程1");
	static Thread t2=new Thread(new myRun2(),"线程2");
	public static void main(String[] args){
		t1.start();
		t2.start();
	}
	static class myRun1 implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(index<s.length()){
				synchronized (ob) {
					if(open){
						System.out.println(s.charAt(index++)+Thread.currentThread().getName());
						open=false;
					}else{
						ob.notifyAll();
						System.out.println("我通知了哈");
						try {
							Thread.sleep(10000L);
							ob.wait();
							System.out.println("我等");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}

	}
	static class myRun2 implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(index<s.length()){
				synchronized (ob) {
					if(!open){
						System.out.println(s.charAt(index++)+Thread.currentThread().getName());
						open=true;
					}else{
						ob.notifyAll();
						try {
							System.out.println("第二个通知了");
							Thread.sleep(10000L);
							ob.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}

	}
}
