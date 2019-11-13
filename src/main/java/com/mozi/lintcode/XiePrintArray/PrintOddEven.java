package com.mozi.lintcode.XiePrintArray;

/**
 * @author :zhouwenbin
 * @time   :19/11/6
 * @comment:
 * https://blog.csdn.net/wangpengzhi19891223/article/details/88538611
 **/
public class PrintOddEven {
	private static volatile int i = 1;
	public static void main(String[] args) {
		Counter counter = new Counter();
//		new Thread(new PrintOdd(counter)).start();
//		new Thread(new PrintEven(counter)).start();


		final Object obj = new Object();

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				synchronized (obj) {
					for (; i <=10; ) {
						System.out.println(Thread.currentThread().getName() + " " + (i++));
						try {
							obj.notifyAll();
							obj.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					obj.notifyAll();
				}
			}
		};

		Thread t1 = new Thread(runnable, "打印偶数的线程 ");
		Thread t2 = new Thread(runnable, "打印奇数的线程 ");
		t2.start();
		t1.start();
	}
}

class Counter {
	public int value = 1;
	public boolean odd = true;
}

class PrintOdd implements Runnable {
	public Counter counter;

	public PrintOdd(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (counter.value <= 100) {
			synchronized (counter) {
				if (counter.odd) {
					System.out.println(counter.value);
					counter.value++;
					counter.odd = !counter.odd;
					//很重要，要去唤醒打印偶数的线程
					counter.notify();
				}
				try {
					counter.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

class PrintEven implements Runnable {
	public Counter counter;

	public PrintEven(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (counter.value <= 100) {
			synchronized (counter) {
				if (!counter.odd) {
					System.out.println(counter.value);
					counter.value++;
					counter.odd = !counter.odd;
					counter.notify();
				}
				try {
					counter.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

