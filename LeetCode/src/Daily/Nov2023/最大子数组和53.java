package Daily.Nov2023;

public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        int min=0;
        int res=Integer.MIN_VALUE;  //注意边界值
        int pre_sum=0;
        for(int num:nums){
            pre_sum+=num;
            res=Math.max(res,pre_sum-min);
            min=Math.min(min,pre_sum);
        }
        return res;
    }
}
