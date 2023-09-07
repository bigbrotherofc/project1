package com.itheima.a;

import java.math.BigInteger;

import static java.lang.Math.*;

public class honor2 {
    public static void main(String[] args) {
        double P_large=0.80;
        int N_means=50;
        int N1=30;
        int N2=40;
        double res=0;
        int p=0;
        int q=0;
        for(int i=0;i<10000;i++){
            int num=0;
            for(int j=0;j<N_means;j++){
                double k=Math.random();
                if(k<P_large){
                  num++;
                }

            }
            if(30<=num&&num<=40) q++;
        }
        System.out.println(q);
    }

}
