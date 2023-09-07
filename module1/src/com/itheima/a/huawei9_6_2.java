package com.itheima.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class huawei9_6_2 {
    static int maxlen = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] map = new int[m][n];
        int[][] falgmap = new int[m][n];
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                backtracing(map,falgmap ,i,j,list);
            }
        }
        System.out.println(maxlen-1);
    }
    static void backtracing(int[][] map,int[][] falgmap,int x,int y,List<Integer[]> list){
        if(isValid(map,falgmap,x+1,y,list)){
            falgmap[x+1][y]=1;
            Integer[] array = new Integer[2];
            array[0]=x+1;
            array[1]=y;
            list.add(array);
            maxlen = Math.max(maxlen,list.size());
            backtracing(map,falgmap,x+1,y,list);
            list.remove(list.size()-1);
        }
        if(isValid(map,falgmap,x-1,y,list)){
            falgmap[x-1][y]=1;
            Integer[] array = new Integer[2];
            array[0]=x-1;
            array[1]=y;
            list.add(array);
            maxlen = Math.max(maxlen,list.size());
            backtracing(map,falgmap,x-1,y,list);
            list.remove(list.size()-1);
        }
        if(isValid(map,falgmap,x,y+1,list)){
            falgmap[x][y+1]=1;
            Integer[] array = new Integer[2];
            array[0]=x;
            array[1]=y+1;
            list.add(array);
            maxlen = Math.max(maxlen,list.size());
            backtracing(map,falgmap,x,y+1,list);
            list.remove(list.size()-1);
        }
        if(isValid(map,falgmap,x,y-1,list)){
            falgmap[x][y-1]=1;
            Integer[] array = new Integer[2];
            array[0]=x;
            array[1]=y-1;
            list.add(array);
            maxlen = Math.max(maxlen,list.size());
            backtracing(map,falgmap,x,y-1,list);
            list.remove(list.size()-1);
        }
    }
    static boolean isValid(int[][] map,int[][] falgmap, int x,int y,List<Integer[]> list){
        if(x<0||x>=map.length||y<0||y>=map[0].length){
            return false;
        }
        if(falgmap[x][y]==1){
          return false;
        }
        if(list.size()==0){
            return true;
        }
        if(list.size()==1){
            int x0 = list.get(list.size()-1)[0];
            int y0 = list.get(list.size()-1)[1];
            if(map[x0][y0]!=map[x][y]){
                return true;
            }else{
                return false;
            }
        }
        int x0 = list.get(list.size()-1)[0];
        int y0 = list.get(list.size()-1)[1];
        int x1 = list.get(list.size()-2)[0];
        int y1 = list.get(list.size()-2)[1];
        if(map[x1][y1]<map[x0][y0]&&map[x0][y0]>map[x][y]){
            return true;
        }
        if(map[x1][y1]>map[x0][y0]&&map[x0][y0]<map[x][y]){
            return true;
        }

        return true;

    }
}


