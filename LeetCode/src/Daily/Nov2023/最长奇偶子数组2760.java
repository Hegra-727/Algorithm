package Daily.Nov2023;

public class 最长奇偶子数组2760 {
    /*public int longestAlternatingSubarray(int[] nums, int threshold) {
        int slow=0;
        int max=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast]>threshold||nums[fast]-nums[slow]%2==0){
                slow++;
            }
            max=Math.max(max,fast-slow+1);
        }
        return max;
    }*/

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len=nums.length;
        int fast=0;
        int max=0;
        while(fast<len){
            if(nums[fast]>threshold||nums[fast]%2!=0){
                fast++;
                continue;
            }
            int slow=fast;
            fast++; //配合fast-1下标使用
            while(fast<len&&nums[fast]<=threshold&&nums[fast-1]%2!=nums[fast]){
                fast++;
            }
            max=Math.max(max,fast-slow);//fast可以达到len所以不要额外+1
        }
        return max;
    }
}
