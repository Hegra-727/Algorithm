package Daily.Nov2023;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 统计和小于目标的下标对数目2824 {
    //排序选中间*2(内循环选择后续起点即可)
    //键值对筛选
    /*public int countPairs(List<Integer> nums, int target) {
        int coun=0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if(nums.get(i)+nums.get(j)<target){
                    coun++;
                }
            }
        }
        return coun;
    }*/

    /*public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int coun=0,left=0,right=nums.size()-1;
        while(left<right){
            if(nums.get(left)+nums.get(right)<target){
                coun+=right-left;
            }else{
                right--;
            }
        }
        return coun;
    }*/

    /*
    //不会用二分捏
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int coun=0,left=0,right=nums.size()-1;
        for (int i = 0; i < nums.size(); i++) {
            int board=binarySearch(nums,target);
            coun+=board;
        }
        return coun;
    }
    int binarySearch(List<Integer> list,int target){
        int l=0,r=list.size()-1;
        while(l<r){
            int mid=r-l>>1+l;
            if(list.get(mid)<target){
                l=mid+1;
            }else
                r=mid;
        }
        return l;
    }*/
}
