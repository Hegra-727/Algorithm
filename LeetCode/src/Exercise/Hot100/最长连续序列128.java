package Exercise.Hot100;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        //1、存入哈希表
        Set<Integer> set=new HashSet<>();
        for(int n:nums)set.add(n);
        int max=0;
        for (int n:set) {
            //2、检查表中新数字（无前缀连续）
            if(!set.contains(n-1)){
                //3、查询连续子序列的长度，更新最值
                int t=n;
                while(set.contains(t+1))t++;
                max=Math.max(max,t-n+1);
            }
        }
        return max;
    }
}
