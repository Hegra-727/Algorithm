package Tmp;

import java.util.HashSet;
import java.util.Set;

public class 最长连续子序列 {
    public int longestConsecutive(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);
        int max=0;
        for(int n:set){
            if(set.contains(n-1))break;
            int t=n;
            while(set.contains(t+1))t++;
            max=Math.max(max,t-n+1);
        }
        return max;
    }
}
