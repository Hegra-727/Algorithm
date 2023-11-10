package Daily.Nov2023;

import java.util.Arrays;

public class 咒语和药水的成功对数2300 {
    //找出对应匹配咒语（乘积大于s）的药水数量
    //找出大于（s/咒语）的药水数量
    /*public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans=new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            for (int j = 0; j < potions.length; j++) {
                if((long)spells[i]*potions[j]>=success)ans[i]++;
            }
        }
        return ans;
    }*/

    /*public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int l=0,r=potions.length-1;
            while(l<r){
                int mid=l+r>>1;
                if(potions[mid]<success/spells[i])
                    l=mid+1;
                else
                    r=mid;
            }
            ans[i]= potions.length-l;
        }
        return ans;
    }*/

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int l=0,r=potions.length-1;
            while(l<r){
                int mid=l+r>>1;
                if(potions[mid]<success*1.0/spells[i])
                    l=mid+1;
                else
                    r=mid;
            }
            if((long) spells[i] * potions[r] >=success)
                ans[i]= potions.length-r;
        }
        return ans;
    }
}
