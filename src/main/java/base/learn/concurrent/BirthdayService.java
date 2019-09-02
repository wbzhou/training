package base.learn.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BirthdayService {

    final int workerNumber;

    final Worker[] workers;

    final ExecutorService threadPool;

    static volatile boolean running = true;

    public BirthdayService(int workerNumber, int capacity) {
        if (workerNumber <= 0) throw new IllegalArgumentException();
        this.workerNumber = workerNumber;
        workers = new Worker[workerNumber];
        for (int i = 0; i < workerNumber; i++) {
            workers[i] = new Worker(capacity);
        }
        //
        boolean b = running;// kill the resorting
        threadPool = Executors.newFixedThreadPool(workerNumber);
        for (Worker w : workers) {
            threadPool.submit(w);
        }
    }

    Worker getWorker(int id) {
        return workers[id % workerNumber];

    }

    class Worker implements Runnable {

        final BlockingQueue<Integer> queue;

        public Worker(int capacity) {
            queue = new LinkedBlockingQueue<Integer>(capacity);
        }

        public void run() {
            while (true) {
                try {
                    consume(queue.take());
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        void put(int id) {
            try {
                queue.put(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void accept(int id) {
        //accept client request
        getWorker(id).put(id);
    }

    protected void consume(int id) {
        //do the work
        //get the list of friends and save the birthday to cache
    }
}
