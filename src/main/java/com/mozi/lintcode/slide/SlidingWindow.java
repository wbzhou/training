package com.mozi.lintcode.slide;


/**
 * @author :zhouwenbin
 * @time   :18/4/17
 * @comment:
 **/

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 滑窗的实现
 * @author zwb
 *这种模式的实现的方式更加契合流控的本质意义。理解较为简单。但由于访问量的不可预见性，会发生单位时间的前半段大量请求涌入，
 *而后半段则拒绝所有请求的情况。（通常，需要可以将单位时间切的足够的小来缓解 ）其次，我们很难确定这个阈值设置在多少比较合适，
 *只能通过经验或者模拟（如压测）来进行估计，即使是压测也很难估计的准确。集群部署中每台机器的硬件参数不同，
 *可能导致我们需要对每台机器的阈值设置的都不尽相同。同一台机子在不同的时间点的系统压力也不一样（比如晚上还有一些任务，
 *或其他的一些业务操作的影响），能够承受的最大阈值也不尽相同，我们无法考虑的周全。 

所以滑窗模式通常适用于对某一资源的保护的需求上（或者说是承诺比较合适：我对某一接口的提供者承诺过，最高调用量不超过XX），
如对db的保护，对某一服务的调用的控制上。 

代码实现思路： 

每一个时间片（单位时间）就是一个独立的计数器，用以数组保存。将当前时间以某种方式
（比如取模）映射到数组的一项中。每次访问先对当前时间片上的计数器+1，再计算前N个时间片的访问量总合，超过阈值则限流。 

 */
public class SlidingWindow {

    /* 循环队列 */
    private volatile AtomicInteger[] timeSlices;
    /* 队列的总长度  */
    private volatile int timeSliceSize;
    /* 每个时间片的时长 */
    private volatile int timeMillisPerSlice;
    /* 窗口长度 */
    private volatile int windowSize;

    /* 当前所使用的时间片位置 */
    private AtomicInteger cursor = new AtomicInteger(0);

    public SlidingWindow(int timeMillisPerSlice, int windowSize) {
        this.timeMillisPerSlice = timeMillisPerSlice;
        this.windowSize = windowSize;
        // 保证存储在至少两个window
        this.timeSliceSize = windowSize * 2 + 1;

    }

    /**
     * 初始化队列，由于此初始化会申请一些内容空间，为了节省空间，延迟初始化
     */
    private void initTimeSlices() {
        if (timeSlices != null) {
            return;
        }
        // 在多线程的情况下，会出现多次初始化的情况，没关系
        // 我们只需要保证，获取到的值一定是一个稳定的，所有这里使用先初始化，最后赋值的方法
        AtomicInteger[] localTimeSlices = new AtomicInteger[timeSliceSize];
        for (int i = 0; i < timeSliceSize; i++) {
            localTimeSlices[i] = new AtomicInteger(0);
        }
        timeSlices = localTimeSlices;
    }

    private int locationIndex() {
        long time = System.currentTimeMillis();
        return (int) ((time / timeMillisPerSlice) % timeSliceSize);
    }

    /**
     * <p>对时间片计数+1，并返回窗口中所有的计数总和
     * <p>该方法只要调用就一定会对某个时间片进行+1
     *
     * @return
     */
    public int incrementAndSum() {
        initTimeSlices();
        int index = locationIndex();
        int sum = 0;
        // cursor等于index，返回true
        // cursor不等于index，返回false，并会将cursor设置为index
        int oldCursor = cursor.getAndSet(index);
        if (oldCursor == index) {
            // 在当前时间片里继续+1
            sum += timeSlices[index].incrementAndGet();
        } else {
            // 可能有其他thread已经置过1，问题不大
            timeSlices[index].set(1);
            // 清零，访问量不大时会有时间片跳跃的情况
            clearBetween(oldCursor, index);
            // sum += 0;
        }
        for (int i = 1; i < windowSize; i++) {
            sum += timeSlices[(index - i + timeSliceSize) % timeSliceSize].get();
        }
        return sum;
    }

    /**
     * 判断是否允许进行访问，未超过阈值的话才会对某个时间片+1
     *
     * @param threshold
     * @return
     */
    public boolean allow(int threshold) {
        initTimeSlices();
        int index = locationIndex();
        int sum = 0;
        // cursor不等于index，将cursor设置为index
        int oldCursor = cursor.getAndSet(index);
        if (oldCursor != index) {
            // 可能有其他thread已经置过1，问题不大
            timeSlices[index].set(0);
            // 清零，访问量不大时会有时间片跳跃的情况
            clearBetween(oldCursor, index);
        }
        for (int i = 1; i < windowSize; i++) {
            sum += timeSlices[(index - i + timeSliceSize) % timeSliceSize].get();
        }

        // 阈值判断
        if (sum <= threshold) {
            // 未超过阈值才+1
            sum += timeSlices[index].incrementAndGet();
            return true;
        }
        return false;
    }

    /**
     * <p>将fromIndex~toIndex之间的时间片计数都清零
     * <p>极端情况下，当循环队列已经走了超过1个timeSliceSize以上，这里的清零并不能如期望的进行
     *
     * @param fromIndex 不包含
     * @param toIndex 不包含
     */
    private void clearBetween(int fromIndex, int toIndex) {
        for (int index = (fromIndex + 1) % timeSliceSize; index != toIndex; index = (index + 1) % timeSliceSize) {
            timeSlices[index].set(0);
        }
    }

}
