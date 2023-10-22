package Daily.Oct2023;

import java.util.Arrays;

public class 做菜顺序1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum=0,ans=0;
        for (int i = satisfaction.length-1; i >0 ; i--) {
            sum+=satisfaction[i];
            if(sum<=0){
                break;
            }
            ans+=sum;
        }
        return ans;
    }
}
