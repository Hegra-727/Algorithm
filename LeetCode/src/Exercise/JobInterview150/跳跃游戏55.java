package Exercise.JobInterview150;

public class 跳跃游戏55 {
    //贪心，只管一一找最远即可，即循环内的max取值
    public boolean canJump(int[] nums) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(i>k)return false;
            k=Math.max(k,i+nums[i]);
        }
        return true;
    }
}
