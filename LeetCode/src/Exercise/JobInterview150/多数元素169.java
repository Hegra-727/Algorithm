package Exercise.JobInterview150;

import java.util.Arrays;
import java.util.Map;

public class 多数元素169 {
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }*/
    /*public int majorityElement(int[] nums) {
        return nums[(int)(Math.random()*nums.length)+1];
    }*/
    //摩尔投票法
    //只有大于n/2的众数可以存活
    public int majorityElement(int[] nums) {
        int cand_num=nums[0],count=1;
        for (int i = 0; i < nums.length; i++) {
            if(cand_num==nums[i])
                count++;
            else if(--count==0){
                cand_num=nums[i];
                count=1;
            }
        }
        return cand_num;
    }
}
