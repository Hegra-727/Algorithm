package Tmp;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        //左右指针，贪心移动
        int l=0,r=height.length-1;
        int max=0;
        int v=0;
        while(l<r){
            v=(r-l)*Math.min(height[l],height[r]);
            max=Math.max(max,v);
            if(height[l]<height[r]){
                l++;
            }else
                r--;
        }
        return max;
    }
}
