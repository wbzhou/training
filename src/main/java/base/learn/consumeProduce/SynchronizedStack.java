package test.consumeProduce;

public class SynchronizedStack {
	private int index=0;
	private int size=100;
	
	private char[] data;
	
	public SynchronizedStack(int size){
		this.size=size;
		data=new char[size];
	}
	
	/**
	 * 生产数据
	 * @param ch
	 */
	public synchronized void push(char ch){
		while(index==size){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		data[index]=ch;
		index++;
		this.notifyAll();
	}
	
	/**
	 * 消费数据
	 * @return
	 */
	public synchronized char pop(){
		while(index==0){
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		index--;
		this.notifyAll();
		return data[index];
	}

}
