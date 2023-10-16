package Daily.Oct2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 只出现一次的数字II137 {
    public static void main(String[] args) {

    }
    static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            int num = entry.getKey() ,value = entry.getValue();
            if(value == 1) {
                ans= num;
                break;
            }
        }
        return ans;
    }
}
