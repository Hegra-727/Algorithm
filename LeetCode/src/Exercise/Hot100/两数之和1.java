package Exercise.Hot100;

import java.util.HashMap;

public class 两数之和1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            hashMap.put(nums[i],i);
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])&&hashMap.get(target-nums[i])!=i)
                return new int[]{i,hashMap.get(target-nums[i])};
        }
        return new int[]{-1,-1};
    }
}
