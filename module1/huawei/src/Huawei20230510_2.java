import java.util.Scanner;

public class Huawei20230510_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int N=in.nextInt();
        in.nextLine();
        char a=in.nextLine().charAt(0);
        for(int i=10;i>0;i--){
            long max=Integer.MIN_VALUE;
            for(int j=0;j+i<s.length();j++){
                long x=Long.parseLong(s.substring(j,j+i));
                if(a=='*'){
                    if(findEqu(x*N)){
                        max=Math.max(max,x);
                    }
                } else if (a=='+') {
                    if(findEqu(x+N)){
                        max=Math.max(max,x);
                    }
                }else if (a=='-') {
                    if(findEqu(x-N)){
                        max=Math.max(max,x);
                    }
                }
            }
            if(max!=Integer.MIN_VALUE){
                System.out.println(max);
                return ;
            }
        }
        System.out.println(-1); 
    }
     static boolean findEqu(long res){
        String s=Long.toString(res,10);
        char c=s.charAt(s.length()-1);
         for (int i = 0; i < s.length(); i++) {
             if(c!=s.charAt(i))return false;
         }
         return true;
    }
}
