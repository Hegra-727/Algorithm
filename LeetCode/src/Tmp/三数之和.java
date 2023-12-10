package Tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        //前后、快慢指针+去重判断+范围控制
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(i>0&&nums[i]==nums[i-1])continue;
            int tg=-nums[i];
            int k=len-1;
            for (int j = i+1; j < len; j++) {
                if(j>i+1&&nums[j]==nums[j-1])continue;
                while(j<k&&nums[j]+nums[k]>tg)k--;
                if(j>=k)break;
                if(nums[j]+nums[k]==tg){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
