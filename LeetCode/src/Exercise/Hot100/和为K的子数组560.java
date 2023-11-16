package Exercise.Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组560 {
    /*public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int count=0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp=0;
                for (int l = i; l <= j; l++) {
                    temp+=nums[l];
                }
                if(temp==k)count++;
            }
        }
        return count;
    }*/

    /*public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int count=0;
        for (int i = 0; i < len; i++) {
            int sum=0;
            for (int j = i; j < len; j++) {
                sum+=nums[j];
                if(sum==k) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }*/

    public int subarraySum(int[] nums, int k) {
        // key:前缀和 value:前缀和的个数
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int preSum=0;
        int count=0;
        for (int num:nums) {
            preSum+=num;
            if(map.containsKey(preSum-k))
                count+=map.get(preSum-k);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

}
