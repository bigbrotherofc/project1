import java.util.LinkedList;
import java.util.Scanner;

public class huawei1 {
    public static void main(String[] args){
        // please define the C input here. FOR EXAMPLE: int n; scanf("%d",&n);
        // please finish the FUNCTION body here.
        // please define the C output here. FOR EXAMPLE: printf("%d",a);
        Scanner in= new Scanner(System.in);
        int poolbegin=in.nextInt();
        int poolend=in.nextInt();
        int alloNums=in.nextInt();
        //Deque<Integer> deque=new ArrayDeque<>();
        LinkedList<Integer> deque=new LinkedList<>();
        for(int i=poolbegin;i<=poolend;i++){
            deque.add(i);
        }
        for(int i=0;i<alloNums;i++){
            if(in.nextInt()==1){
                int kNum=in.nextInt();
                for(int j=0;j<kNum;j++){
                    int resId=deque.removeFirst();
                }
            }else if(in.nextInt()==2){
                int KId=in.nextInt();
                if(deque.contains(KId)){
                    deque.remove(new Integer(KId));
                }
            }else{
                int Nid=in.nextInt();
                if(!deque.contains(Nid)){
                    deque.add(Nid);
                }
            }
        }
        System.out.println(deque.getFirst());
    }
}