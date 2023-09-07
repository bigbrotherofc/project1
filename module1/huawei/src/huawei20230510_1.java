import java.sql.SQLOutput;
import java.util.*;

public class huawei20230510_1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        String[] sarray=s.split(" ");
        Integer[] nums=new Integer[sarray.length];

        for(int i=0;i<sarray.length;i++){
            nums[i]=Integer.parseInt(sarray[i]);
            //System.out.println(nums[i]);
        }
        Deque<Integer> stack=new ArrayDeque<>();
        Deque<Integer> stack2=new ArrayDeque<>();
        //Deque<Map<Integer,Long>> staset=new ArrayDeque<>();
        stack.push(nums[0]);
        //Map<Integer,Long> perMap=new HashMap<>();
        //perMap.put(0, Long.valueOf(nums[0]));
        //staset.add(perMap);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<stack.peek()){
                stack.push(nums[i]);
            }else{
                int sum=0;
                while(sum<nums[i]){
                    int top=stack.pop();
                    sum+=top;
                    stack2.push(top);
                }
                if(sum==nums[i]){
                    sum=0;
                    while(stack2.isEmpty()&&sum!=nums[i]){
                        sum+=stack2.pop();
                    }
                    stack.pop();
                    stack.push(nums[i]*2);
                }else{
                    while(stack2.isEmpty()){
                        stack.push(stack2.pop());
                    }
                    stack.push(nums[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }

}
