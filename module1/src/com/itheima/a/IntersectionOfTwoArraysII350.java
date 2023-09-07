package com.itheima.a;
import java.util.*;

public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] a=intersect1(nums1,nums2);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1=new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            int key = nums1[i];
            if(map1.containsKey(key)){
                count=map1.get(key);
            }
            count++;
            map1.put(key,count);
            count=0;
        }
        for(int i=0;i<nums2.length;i++){
            int key = nums2[i];
            if(map1.containsKey(key)){
                if(map2.containsKey(key)){
                    count=map2.get(key);
                }
                count++;
                map2.put(key,count);
                count=0;
            }
        }
        Set<Integer> keys=map2.keySet();
        for(int key:keys){
            int count1=map1.get(key);
            int count2=map2.get(key);
            count=Math.min(count1,count2);
            for(int i=0;i<count;i++){
                list.add(key);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
    public static int[] intersect1(int[] nums1, int[] nums2) {
        //使用列表，通过增减使数量相同
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int num:nums1){
            list1.add(num);
        }
        for(int num:nums2){
            if(list1.contains(num)){
                list2.add(num);
                list1.remove(Integer.valueOf(num));
            }
        }
        return list2.stream().mapToInt(x->x).toArray();
    }
}
