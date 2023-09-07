package com.itheima.a;

public class reverseStringII541 {
    public static void main(String[] args) {
        int k=39;
        String s="hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        System.out.println(s.length());
        reverseStr(s,k);

    }
    public static String reverseStr(String s, int k) {
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;i+=2*k){
            if((ss.length-i)<k){
                int left=0+i;
                int right=ss.length-1;
                reverse(ss,left,right);
            }
            else{
                int left=0+i;
                int right=k-1+i;
                reverse(ss,left,right);
            }
        }
        return String.copyValueOf(ss);
    }
    public static char[] reverse(char[] s,int left,int right){
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        return s;
    }
}
