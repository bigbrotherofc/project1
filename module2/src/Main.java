import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //输入的几个等级
        char[] charArray = new char[100];
        TreeSet<Character> set=new TreeSet<>();
        for(int i=0;i<charArray.length;i++){
            set.add(charArray[i]);
        }
        char m=set.first();
        char n=set.last();
        int[] nums=new int[26];
        for (int i = 0; i < 26; i++) {
            nums[i]=(i+1)*10;
        }
        int k=n-m;
        int p=m-'a';
        int sum=0;
        for(int i=p;i<p+k;i++){
            sum+=nums[i];
        }
    }
}