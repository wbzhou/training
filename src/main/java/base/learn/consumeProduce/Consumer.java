package test.consumeProduce;

public class Consumer implements Runnable{

	private SynchronizedStack stack;

	public Consumer(SynchronizedStack s) {
		this.stack=s;
	}
	
	public void run() {
		char ch;
		for(int i=0;i<100;i++){
			ch=stack.pop();
		    System.out.println(ch);
			i++;
			try {
				// 每产生一个字符线程就睡眠一下
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
