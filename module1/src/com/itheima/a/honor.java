package com.itheima.a;

import java.util.Scanner;
public class honor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        int i=0;
        char firstChar=' ';
        while(i<line.length()&&line.charAt(i)==' '){
            i++;
        }
        int start=i;
        firstChar=line.charAt(i);
        while(i<line.length()&&!(line.charAt(i)==' ')){
            i++;
        }
        int end=i;
        long res=0;
        System.out.println(firstChar);
        if(firstChar=='+'){
            res=Long.parseLong(line.substring(start+1,end));
        }else if(firstChar=='-'){
            res=(-1)*Long.parseLong(line.substring(start+1,end));
        }else if(firstChar>='0'&&firstChar<='9'){

            res=(-1)*Long.parseLong(line.substring(start,end));
        }else{
            res=0;
        }
        if(res<Integer.MAX_VALUE&&res>Integer.MIN_VALUE){
            res=Integer.MAX_VALUE;
        }
        System.out.println(res);

    }
}
