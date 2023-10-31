package Daily.Nov2023;

import java.util.*;

public class 参加会议的最多员工数2127 {
    /*public int maximumInvitations(int[] favorite) {
        int ans=0;
        int groupOf2=0;//记录二人喜欢组加上最长枝的长度
        int loved[]=new int[favorite.length];//记录每个人被多少人喜欢
        int maxL[]=new int[favorite.length];//记录每个在树枝上的点到自己位置一共多少个
        List<Integer> love[]=new ArrayList[favorite.length];//记录每个人具体被谁喜欢了
        Arrays.fill(love,new ArrayList<>());
        Arrays.fill(maxL,1);
        //第一次遍历数组，记录恋爱关系
        for(int i=0;i<favorite.length;i++){
            loved[favorite[i]]++;
            love[favorite[i]].add(i);
        }
        LinkedList<Integer> q=new LinkedList<>();
        for(int i=0;i<favorite.length;i++){if(loved[i]==0){q.add(i);}}//没人爱的人一定是枝叶的末端
        while(q.size()>0){
            int a=q.removeFirst();
            loved[favorite[a]]--;
            //凡是可以减到0的都在枝上
            if(loved[favorite[a]]==0){q.add(favorite[a]);}
            //然后更新所在枝大小
            maxL[favorite[a]]=Math.max(maxL[favorite[a]],maxL[a]+1);
        }
        //下面开始遍历所有数字，遇到环（也就是此时loved还没有减到0），就一直找到环的大小，大小为2的环需要找到所在的最长的枝并统计
        for(int i=0;i<favorite.length;i++){
            if(loved[i]==0){continue;}
            if(favorite[favorite[i]]==i){groupOf2+=maxL[i];}//这里只算了一半（当然也可以俩一起算，再把另一个的fav设为0）
            else{
                int l=0,pre=i;
                while(true){
                    l++;
                    loved[pre]=0;
                    pre=favorite[pre];
                    if(pre==i){break;}
                }
                ans=Math.max(ans,l);
            }
        }
        return Math.max(ans,groupOf2);
    }*/

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++; // 统计基环树每个节点的入度
        }

        int[] maxDepth = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) { // 拓扑排序，剪掉图上所有树枝
            int x = q.poll();
            int y = favorite[x]; // x 只有一条出边
            maxDepth[y] = maxDepth[x] + 1;
            if (--deg[y] == 0) {
                q.add(y);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) continue;

            // 遍历基环上的点
            deg[i] = 0; // 将基环上的点的入度标记为 0，避免重复访问
            int ringSize = 1; // 基环长度
            for (int x = favorite[i]; x != i; x = favorite[x]) {
                deg[x] = 0; // 将基环上的点的入度标记为 0，避免重复访问
                ringSize++;
            }

            if (ringSize == 2) { // 基环长度为 2
                sumChainSize += maxDepth[i] + maxDepth[favorite[i]] + 2; // 累加两条最长链的长度
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize); // 取所有基环长度的最大值
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }
}
