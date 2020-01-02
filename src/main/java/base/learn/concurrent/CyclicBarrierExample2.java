package base.learn.concurrent;

import java.util.concurrent.*;

/**
 * @author :zhouwenbin
 * @time   :20/1/2
 * @comment:https://www.jianshu.com/p/0e227207f6df
 * CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大，主要应用场景和 CountDownLatch 类似。

CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，所有被屏障拦截的线程才会继续干活。CyclicBarrier 默认的构造方法是 CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用 await() 方法告诉 CyclicBarrier 已经到达了屏障，然后当前线程被阻塞。

CyclicBarrier 的应用场景
CyclicBarrier 可以用于多线程计算数据，最后合并计算结果的应用场景。比如用一个 Excel 保存用户所有的银行流水，每个 Sheet 保存一个帐户近一年的每笔银行流水，现在需要统计用户的日均银行流水，先用多线程处理每个 sheet 里的银行流水，都执行完之后，得到每个 sheet 的日均银行流水，最后，再用 barrierAction 用这些线程的计算结果，计算出整个 Excel 的日均银行流水。

作者：happyJared
链接：https://www.jianshu.com/p/0e227207f6df
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class CyclicBarrierExample2 {
	// 请求的数量
	private static final int threadCount = 550;
	// 需要同步的线程数量
	private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

	public static void main(String[] args) throws InterruptedException {
		// 创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < threadCount; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			threadPool.execute(() -> {
				try {
					test(threadNum);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		threadPool.shutdown();
	}

	public static void test(int threadnum) throws InterruptedException, BrokenBarrierException {
		System.out.println("threadnum:" + threadnum + "is ready");
		try {
			/**等待60秒，保证子线程完全执行结束*/
			cyclicBarrier.await(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("-----CyclicBarrierException------");
		}
		System.out.println("threadnum:" + threadnum + "is finish");
	}

}