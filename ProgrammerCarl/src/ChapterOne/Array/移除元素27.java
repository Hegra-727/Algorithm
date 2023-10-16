package ChapterOne.Array;

public class 移除元素27 {
    /*static int removeElement(int[] nums,int val){
        int slow=0,fast=0;
        for (int i = 0; i < nums.length; i++) {
            while(nums[fast++]!=val)
                nums[slow++]=nums[fast];
        }
        return slow-1;
    }*/
    int removeElement(int[] nums,int val){
        int slow=0;
        for (int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val)
                nums[slow++]=nums[fast];
        }
        return slow;
    }
}
