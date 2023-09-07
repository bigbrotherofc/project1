package com.itheima.a;

import java.util.*;

public class liulian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int L= in.nextInt();
            int R = in.nextInt();
            int m = in.nextInt();
            System.out.println(getNum(L,R,m));
        }
    }
    static int getNum(long  L,long R,long m){
        if(L+R<m){
            return 0;
        }
        if(L>=m){
            return 0;
        }
        R = m-L;
        if(m%2==1){
            return (int)((R-L)/2)+1;
        }else{
            return (int)((R-L)/2);
        }
    }


}
