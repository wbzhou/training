package test.consumeProduce;

public class Producer implements Runnable{
	private SynchronizedStack stack;

	public Producer(SynchronizedStack s) {
		this.stack=s;
	}
	
	public void run() {
		char ch;
		for(int i=0;i<100;i++){
			//// 随机产生100个字符
			ch=(char)(Math.random()*26+'A');
			stack.push(ch);
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
