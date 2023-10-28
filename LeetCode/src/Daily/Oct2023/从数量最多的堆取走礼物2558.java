package Daily.Oct2023;


import java.util.PriorityQueue;
import java.util.Queue;

public class 从数量最多的堆取走礼物2558 {
    //数组的最大数只保留(int)平方根
    //k次循环
    /*public HashMap<Integer,Integer> map=new HashMap<>();
    public long pickGifts(int[] gifts, int k) {
        int max=Integer.MIN_VALUE;

        while(k--!=0){
            int i = 0;
            for (; i < gifts.length; i++) {
                if(gifts[i]>max) max=gifts[i];
            }

        }
    }*/
    /*public long pickGifts(int[] gifts, int k) {
        int len=gifts.length-1;
        while(k--!=0){
            Arrays.sort(gifts);
            gifts[len] = (int)Math.sqrt(gifts[len]);
        }
        long res=0;
        for(int g:gifts)
            res+=g;
        return res;
    }*/
    public long pickGifts(int[] gifts, int k) {
        int res=0;
        Queue<Integer> queue=new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < gifts.length; i++) {
            queue.offer(gifts[i]);
        }
        while(k--!=0)
            queue.offer((int)Math.sqrt(queue.poll()));
        for(int t:queue)
            res+=t;
        return res;
    }
}