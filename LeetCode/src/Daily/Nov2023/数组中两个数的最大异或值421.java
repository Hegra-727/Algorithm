package Daily.Nov2023;

import java.util.HashSet;
import java.util.Set;

public class 数组中两个数的最大异或值421 {
    /*public int findMaximumXOR(int[] nums) {
        if(nums.length==1)return 0;
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                res=Math.max(res,nums[i]^nums[j]);
            }
        }
        return res;
    }*/

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int highBit = 31 - Integer.numberOfLeadingZeros(max);

        int ans = 0, mask = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = highBit; i >= 0; i--) { // 从最高位开始枚举
            seen.clear();
            mask |= 1 << i;
            int newAns = ans | (1 << i); // 这个比特位可以是 1 吗？
            for (int x : nums) {
                x &= mask; // 低于 i 的比特位置为 0
                if (seen.contains(newAns ^ x)) {
                    ans = newAns; // 这个比特位可以是 1
                    break;
                }
                seen.add(x);
            }
        }
        return ans;
    }
}
