package Daily.Oct2023;

import java.util.*;

public class 避免洪水泛滥1488 {
    public static void main(String[] args) {

    }
    //rain[]表示下满哪个湖泊，只有0时，才可以抽水
    //避免rain[]连续重复，除非有0插入
    /*static int[] avoidFlood(int[] rains) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            if(rains[i]!=0&&set.add(rains[i])){

            }
        }
    }*/

    //nlog(n)
    //湖的个数、储量 抽水、下雨  根据下雨预测贪心式抽水
    /*public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> nextMap = new HashMap<>();
        //1、记录每个湖泊即将下一次降雨的索引,如果不会出现记为Integer.MAX_VALUE
        int[] next = new int[rains.length];
        for (int i = rains.length - 1; i >= 0; i--) {
            next[i] = nextMap.getOrDefault(rains[i], Integer.MAX_VALUE);
            nextMap.put(rains[i], i);
        }
        //2、湖泊个数full 湖水储量sum 选择抽水的湖泊号res 满水队列queue
        //已满水湖泊的个数
        Set<Integer> full = new HashSet<>();
        //所有满水湖泊的储水量,下雨 +1,不下雨抽干 -1
        int sum = 0;
        int[] res = new int[rains.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //3、天气开始运转
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                full.add(rains[i]);
                queue.offer(next[i]);
            }
            //default
            res[i] = -1;
            //下雨储水量 + 1; 不下雨储水量可能 -1
            sum += rains[i] > 0 ? 1 : -1;
            //储水量大于已满湖泊的个数，说明此时有一个湖泊间接性下了两次雨，但是前一次没有抽干，就会出现洪水
            if (sum > full.size()) return new int[0];
            //后面还会出现且该湖泊当前已满的可选择性抽干，后面不出现的可以不用抽干，也可随机抽干
            //先抽干当前已经满，且最快再次出现降雨的湖泊，避免发生洪水
            //这个优先队列怎么满足贪心策略的？这些res[] -1 1的default值是什么鬼?抽象对象模拟情况
            if (rains[i] == 0) {
                //default
                res[i] = 1;
                //抽干选择2 ：优选选择当前已满，且下一次最快出现降雨的湖泊进行抽干,对应sum - 1
                if (!queue.isEmpty() && queue.peek() != Integer.MAX_VALUE) {
                    int lakeIndex = queue.poll();
                    full.remove(rains[lakeIndex]);
                    res[i] = rains[lakeIndex];
                } else {
                    //抽干选择1 ：如果只剩下不会出现洪水的湖泊或者是没有湖泊满水，那么湖泊满的总数不变,对应可能 sum - 1
                    sum++;
                }
            }
        }
        return res;
    }*/


    //TreeSet有序集合 sunny
    //HashMap哈希 lakeLastRain
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> sunny = new TreeSet<>();   // 有序集合，记录可用的晴天
        Map<Integer, Integer> lakeLastRain = new HashMap<>();   // 记录每个湖泊上一次下雨的时间
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);    // 初始化ans所有值都为1，来使得剩余可用晴天默认抽干一号湖泊
        for(int i = 0; i < n; i++){
            if(rains[i] == 0){
                sunny.add(i);   // 将晴天的这一天加入有序集合
            }else{
                ans[i] = -1;    // 下雨天，这一天的ans肯定为-1
                if(lakeLastRain.containsKey(rains[i])){
                    // 如果这个湖泊之前也下过雨，我们就要两个下雨的区间内找到最早的不下雨天来抽空这个湖泊
                    Integer norain = sunny.ceiling(lakeLastRain.get(rains[i]));
                    if(norain == null)return new int[0];    // 如果没有晴天，肯定发洪无法阻止
                    ans[norain] = rains[i]; // 否则，找到的晴天抽空rains[i]湖泊
                    sunny.remove(norain);   // 这个晴天已经使用了，移除集合
                }
                lakeLastRain.put(rains[i], i);  // 记录rains[i]号湖泊这一天下过雨
            }
        }
        return ans;
    }
}
