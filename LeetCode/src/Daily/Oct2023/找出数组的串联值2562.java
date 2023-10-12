package Daily.Oct2023;

public class 找出数组的串联值2562 {
    public static void main(String[] args) {

    }
    //nt模拟，又臭又长
    /*public long findTheArrayConcVal(int[] nums) {
        // len/2中间坐标，len-i则表示对称
        if(nums.length==1)return nums[0];
        int res=0;
        for (int i = 0,j= nums.length-1-i; i < nums.length/2; i++) {
            res+=Integer.valueOf(String.valueOf(nums[i])+String.valueOf(nums[j]));
            if(i==j-2)res+=nums[nums.length/2];
        }
        return res;
    }*/
    //双指针+拼接数字
    public long findTheArrayConcVal(int[] nums) {
        int i=0,j=nums.length-1;
        long res=0;
        while (i<j){
            int nums1=nums[i++],nums2=nums[j--];
            res+=(long)nums1*Math.pow(10,(int)Math.log10(nums2)+1)+nums2;
        }
        return i==j?res+nums[i]:res;
    }
}
