package com.itheima.a;

import java.util.*;

public class fourSum18 {
    public static void main(String[] args) {
        int target= -294967296;
        int[] nums={1000000000,1000000000,1000000000,100000000};
        List<List<Integer>> list=fourSum(nums,target);

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> reslut=new ArrayList<>();
        if(nums.length<4)return reslut;
        Arrays.sort(nums);
        int left=1;
        int right=nums.length-2;
        int sum=0;
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=nums.length-1;j>i+2;j--){
                if((j<nums.length-1)&&nums[j]==nums[j+1])continue;
                left= i+1;
                right=j-1;
                while(left<right){
                    sum=nums[i]+nums[left]+nums[right]+nums[j];
                    if(sum<target){
                        left++;
                    }else if(sum>target){
                        right--;
                    }else if(sum ==target){
                        reslut.add(Arrays.asList(nums[i],nums[left],nums[right],nums[j]));
                        while(left<right&&nums[left]==nums[left+1])left++;
                        while(left<right&&nums[right]==nums[right-1])right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return reslut;
    }
}
