package Daily.Oct2023;

import java.util.Arrays;

public class 切割后面积最大的蛋糕1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH=getMaxSize(h,horizontalCuts);
        int maxW=getMaxSize(w,verticalCuts);
        return (int)((long)maxW*maxH%(int)(1e9+7));
    }
    private int getMaxSize(int size,int[] cuts){
        //排序，按顺序执行便于贪心实现
        Arrays.sort(cuts);
        //头尾的空余，加入max判断
        int res=Math.max(cuts[0],size-cuts[cuts.length-1]);
        for (int i = 1; i < cuts.length; i++) {
            res=Math.max(res,cuts[i]-cuts[i-1]);
        }
        return res;
    }
}
