package Daily.Oct2023;

import java.util.Arrays;

public class H指数274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int t=citations.length-1;
        int h=0;
        //论文数量和引用数量两个条件的相互制约
        //h篇引用多于h次的论文，求h
        //排序，递增
        while(t>=0&&citations[t]>h){
            t--;
            h++;
        }
        return h;
    }
}
