package com.mozi.lintcode.slide;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author :zhouwenbin
 * @time   :18/4/18
 * @comment:
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 **/
public class PriorityQueueWay {



	@Test
    public void test(){

        System.out.println("哈哈");
        Solution so=new Solution();
        List<Integer> list=so.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        for(Integer entry: list){
            System.out.println("max为:"+entry);
        }
    }

}


class tmp{
    public tmp() {
    }

    public tmp(Integer num,Integer pos) {
        this.pos = pos;
        this.num = num;
    }

    public Integer pos;
    public Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

}

 class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (num==null)
            return arr;
        if (num.length<size||size<=0)
            return arr;
        PriorityQueue<tmp> priorityQueue = new PriorityQueue<>(100, new Comparator<tmp>() {
            @Override
            public int compare(tmp o1, tmp o2) {
                return o2.num-o1.num;
            }
        });
        for (int i=0;i<size-1;i++)
            priorityQueue.offer(new tmp(num[i],i));
        for (int i=size-1;i<num.length;i++){
            priorityQueue.offer(new tmp(num[i],i));
            tmp p = priorityQueue.peek();
            while (p.getPos()<i-(size-1)){
                priorityQueue.poll();
                p = priorityQueue.peek();
            }
            arr.add(p.getNum());
        }

        return arr;

    }
}