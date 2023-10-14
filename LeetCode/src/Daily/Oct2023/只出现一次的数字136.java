package Daily.Oct2023;

public class 只出现一次的数字136 {
    public static void main(String[] args) {

    }
    static int singleNumber(int[] nums) {
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
