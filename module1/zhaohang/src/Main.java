import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N=in.nextInt();
        int K=in.nextInt();
        Map<Integer,List<Integer>> lines=new HashMap<>();
        //int[] lines=new int[N+1];
        //Map<Integer,Integer> lines=new HashMap<>();
        List<List<Integer>> match=new ArrayList<>();
        match.add(new ArrayList<Integer>());
        for (int i = 0; i <N; i++) {
            //lines.put(in.nextInt(),i+1);
            int num=in.nextInt();
            if(lines.keySet().contains(num)){
                lines.get(num).add(i+1);
            }else{
                List temp=new ArrayList();
                temp.add(i+1);
                lines.put(num,temp);
            }
        }
        in.nextLine();
        for (int i = 0; i < K; i++) {
            String tempStr=in.nextLine();
            List list=new ArrayList();
            for (int j = 1; j < K+1; j++) {
                if(tempStr.charAt(j-1)=='1'){
                  list.add(j);
                }
            }
            match.add(list);
        }
        List<Integer>path =new ArrayList<>();
        res=Integer.MAX_VALUE;
        backtracing(match,lines,path,match.get(1).get(0),N);
        if(res==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }


    }
    public static void backtracing(List<List<Integer>> match,Map<Integer,List<Integer>> lines,List<Integer> path,Integer k,int N){
        if(path.size()>N)return ;
        if(path.size()>0&&path.get(path.size()-1)==N){
            path.add(0,match.get(1).get(0));
            int tempRes=0;
            for (int i = 1; i <path.size() ; i++) {
                tempRes+=Math.abs(path.get(i)-path.get(i-1));
            }
            res=res<tempRes?res:tempRes;
            return ;
        }
        for(Integer i:match.get(k)){
            for(Integer j:lines.get(i)){
                if(path.contains(j))return;
                path.add(j);
                backtracing(match,lines,path,i,N);
                path.remove(path.size()-1);
            }
        }
    }
}