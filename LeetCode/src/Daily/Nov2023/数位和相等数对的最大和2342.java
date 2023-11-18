package Daily.Nov2023;

import java.util.HashMap;
import java.util.Map;

public class 数位和相等数对的最大和2342 {
    //记录位数和相等的（拆元素计数）
    //考虑最大的两个（单调队列）
    //计数+队列存数

/*    public int maximumSum(int[] nums){
//        Map<Integer,Integer> map=new HashMap<>();
        int[][] coun=new int[100010][100010];
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            int temp=nums[i];
            while(nums[i]!=0){
                sum+=nums[i]%10;
                nums[i]/=10;
            }
//            map.put(sum,map.getOrDefault(map.get(sum),0)+1);
            coun[temp][sum]=temp;//list存元素记录？
            while (coun[temp][])
//            coun[sum]++;
//            while(coun[sum]>2)
        }

    }*/

    //单维护就行后续筛选，想着多维护的话就是topk问题了？
    public int maximumSum(int[] nums){
        int[] mx=new int[82];
        int res=-1;
        for(int num:nums){
            int t=0;
            for (int i = num; i >0 ; i/=10) {
                t+=i%10;
            }
            //出现同数位和的数字（重复），则挑选最大和
            if(mx[t]>0) {
                res=Math.max(res,mx[t]+num);
            }
            //给左边进行单维护最大结果，不保留状态/记录。保证了第一个数是顺序下最大的
            mx[t]=Math.max(mx[t],num);
        }
        return res;
    }
}
