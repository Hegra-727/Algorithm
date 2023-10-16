package Daily.Oct2023;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字III260 {
    public static void main(String[] args) {

    }
    /*static int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        int[] ans=new int[2];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            int key= entry.getKey() , value= entry.getValue();
            if(value==1){
                ans[i++]=key;
            }
        }
        return ans;
    }*/

    /** 只有两个不同值，其它都是两两配对的相同值
     * 1、首先得到两个不同值的异或结果xor
     * 2、对这结果可以肯定在某位置是0、1配对的存在（异或的独特作用===>即xor>>k&1==0,伴随k++计算
     * 3、划分为两组进行异或运算,注意两组并不对等（但同值必然划分到一组），不影响以异或方式求出ans具体值
     * @param nums
     * @return
     */
    static int[] singleNumber(int[] nums) {
        int[] ans=new int[2];
        int xor=0;
        for(int num:nums) xor^=num;
        int k=0;
        while((xor>>k&1)==0)k++;
        for(int num:nums){
            if((num>>k&1)==0)
                ans[0]^=num;
            else
                ans[1]^=num;
        }
        return ans;
    }
}
