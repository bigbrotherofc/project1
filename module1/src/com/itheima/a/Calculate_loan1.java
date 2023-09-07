package com.itheima.a;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculate_loan1 {
    /**
     * 计算每月还款额度
     * @param p:本金
     * @param mr：月利率
     * @param M：需要还款的总月份
     * @return:返回所需每月所需要还款的额度
     */
    public static double Calculate_Equal_principal_and_interest(double p,double mr,int M){
        return p*mr*Math.pow((1+mr),M)/(Math.pow((1+mr),M)-1);
    }

    /**
     *
     * @param payment：每月还款总额
     * @param M：总还款月份
     * @param p：本金总额
     * @param mr：月利率
     */
    static void printDetails(double payment,int M,double p,double mr){

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

    /**
     * 输入本金p并检查是否出错
     * @return
     */
    static double inputandcheckp(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input 本金：");
        double p = scanner.nextDouble();
        if (p < 0) {
            throw new IllegalArgumentException("本金必须大于零");
        }
        return p;
    }

    /**
     * 输入利率p并检查是否出错
     * @return
     */
    static double inputandcheckmr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 利息：");
        double mr = scanner.nextDouble();
        if (mr < 1||mr>36) {
            throw new IllegalArgumentException("利息必须大于1小于36");
        }
        return mr/1200;
    }

    /**
     * 输入年份M并检查是否出错，并以月份形式返回
     * @return
     */
    static int inputandcheckM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 贷款年数：");
        int M = scanner.nextInt();
        if (M < 1||M>40) {
            throw new IllegalArgumentException("必须大于一年，小于等于四十年");
        }
        return M*12;
    }

    public static void main(String[] args) {
        double p = inputandcheckp();
        double mr = inputandcheckmr();
        int M = inputandcheckM();
        Scanner scanner=new Scanner(System.in);
        System.out.println("等额本金请输入：1\n等额本息请输入：2");
        int flag = scanner.nextInt();
        if (flag == 1) {

        }
        else {
            double payment = Calculate_Equal_principal_and_interest(p, mr, M);
            System.out.println("每月还款数："+NumberFormat.getCurrencyInstance().format(payment));
            System.out.println("总还款数："+NumberFormat.getCurrencyInstance().format(payment*M));
            printDetails(payment,M,p,mr);
        }

    }
}
