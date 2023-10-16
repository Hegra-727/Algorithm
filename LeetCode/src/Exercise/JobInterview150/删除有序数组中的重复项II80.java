package Exercise.JobInterview150;

public class 删除有序数组中的重复项II80 {
    public int removeDuplicates(int[] nums) {
        //给fast维持一个窗口？slow在后面填充
        int slow=2;
        for (int fast = 2; fast < nums.length; fast++) {
            //这里是nums[fast]!=nums[slow-2],呜呜呜，不是两个fast
            //slow快进会对判断产生干扰，判定时多了一个重复值
            if(nums[fast]!=nums[slow-2])
                nums[slow++]=nums[fast];
        }
        return slow;
    }
}
