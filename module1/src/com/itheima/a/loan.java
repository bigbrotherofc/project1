package com.itheima.a;

import java.text.NumberFormat;
import java.util.Scanner;

public class loan {
    public static double Calculate_Equal_principal_and_interest(int p,double mr,int M){
        return p*mr*Math.pow((1+mr),M)/(Math.pow((1+mr),M)-1);
    }


    /*public double Equivalent_principal() {

    }*/
    public static void main(String[] args) {
        System.out.println("Please input 本金：");
        Scanner scanner=new Scanner(System.in);
        int p=scanner.nextInt();
        System.out.println("Please input 利息：");
        double mr=scanner.nextDouble()/1200;
        System.out.println("Please input 年份：");
        int M=scanner.nextInt()*12;

        System.out.println("等额本金请输入：1\n等额本息请输入：2");
        int flag = scanner.nextInt();
        if (flag == 1) {

        }
        else {
            double payment = Calculate_Equal_principal_and_interest(p, mr, M);
            System.out.println("每月还款数："+NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("总还款数："+NumberFormat.getCurrencyInstance().format(payment*M));
            double sum_interest = 0;
            double sum_principal = 0;

            for(int i=0;i<M;i++){
                double payinterest = p * mr;
                sum_interest+=payinterest;

                double payprincipal=payment-payinterest;
                sum_principal+=payprincipal;

                p-=payprincipal;
                System.out.print("月份" + (i + 1));
                System.out.print("\t本月还款" + NumberFormat.getCurrencyInstance().format(payment));
                System.out.print("\t本月利息" + NumberFormat.getCurrencyInstance().format(payinterest));
                System.out.println("\t本月本金" + NumberFormat.getCurrencyInstance().format(payprincipal));
            }
            System.out.println("总利息："+NumberFormat.getCurrencyInstance().format(sum_interest));
            System.out.println("总本金："+NumberFormat.getCurrencyInstance().format(sum_principal));

        }


    }




}