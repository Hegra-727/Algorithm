package Daily.Nov2023;

import java.util.Arrays;

public class K个元素的最大和2656 {
    /*public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        for (int i = 0; i < k; i++) {
            res+=nums[nums.length-1]++;
        }
        return res;
    }*/

    //顺序查找最值+等差数列求和
    public int maximizeSum(int[] nums, int k) {
        int max=0;
        for (int n:nums) max=Math.max(max,n);
        int res=0;
        res=(2*max+k-1)*k/2;
        return res;
    }
}
