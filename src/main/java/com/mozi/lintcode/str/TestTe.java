package com.mozi.lintcode.str;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/5/12
 */
public class TestTe {
    public static void main(String[] args){

        int nums[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int nums1[]=new int[]{-2,-5,-1,-10,-1};
        int max1=getMax(nums);
         System.out.println(max1);
        System.out.println(getMax(nums1));



    }

    public  static  int getMax(int nums[]){
//        int dip[]=new int[nums.length];
//        dip[0]=nums[0];
        int max=nums[0];

//        for(int i=1;i<nums.length;i++){
//            if(dip[i-1]+nums[i]>nums[i])
//                dip[i]=dip[i-1]+nums[i];
//            else
//                dip[i]=nums[i];
//            if(max<dip[i]) {
//                max = dip[i];
//            }
//        }
        for(int i=1;i<nums.length;i++){
            if(max+nums[i]>nums[i])
                max=Math.max(max,nums[i-1]+nums[i]);
            else
                max=Math.max(max,nums[i]);

        }
        return max;
    }

}
