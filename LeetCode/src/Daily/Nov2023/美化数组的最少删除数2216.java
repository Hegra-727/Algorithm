package Daily.Nov2023;

import java.util.Deque;
import java.util.LinkedList;

public class 美化数组的最少删除数2216 {
    public int minDeletion(int[] nums) {
        Deque<Integer> stack=new LinkedList<>();
        for(int num:nums){
            //事阅读理解！
            if(!(stack.size()%2==1&&stack.getLast()==num)){
                stack.addLast(num);
            }
        }
        if(stack.size()%2==0)
            return nums.length-stack.size();
        else
            return nums.length-stack.size()+1;
    }
}
