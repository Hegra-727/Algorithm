package Exercise.JobInterview150;

public class 删除有序数组中的重复项26 {
    public int removeDuplicates(int[] nums) {
        //双指针(但是需要校正初始值 以及 前后比较关系.
        //我把fast、slow都初始为0时，恰好不好给数组分配nums[0]，以及前后比较的数组下标越界问题
        //倾向于向前比较 fast、fast-1
        //向后一方面要改循环条件nums.length-1、重要的是不能让slow取到fast+1(如果最后两数不重复时)
        int slow=1;
        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast]!=nums[fast-1])
                nums[slow++]=nums[fast];
        }
        return slow;
    }
}
