package Daily.Oct2023;

import java.util.HashMap;

public class 同积元组1726 {
    /*//找同积
    //排列组合
    public int tupleSameProduct(int[] nums) {
        //统计<乘积,数量>对
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int key=nums[i]*nums[j];
                hashMap.put(key,hashMap.getOrDefault(key,0)+1);
            }
        }
        int ans=0;
        for(int value:hashMap.values()){
            ans+=value*(value-1)*4;
        }
        return ans;
    }*/

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int ans=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                //分离键值对
                int key=nums[i]*nums[j];
                int value=hashMap.getOrDefault(key,0)+1;
                //value默认2才开始计算，刚好符合元组的配对，同时也是一个简单的排列组合公式使用
                ans+=(value-1)*8;
                hashMap.put(key,value);
            }
        }
        return ans;
    }
}
