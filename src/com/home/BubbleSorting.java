package com.home;

public class BubbleSorting {
    public static void main(String[] args){
        int[] nums = {1,5,8,9,10,13,15,2,4};
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length-1; j++) {
                if(nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        for (int element: nums) {
            System.out.println(element);
        }
    }
}
