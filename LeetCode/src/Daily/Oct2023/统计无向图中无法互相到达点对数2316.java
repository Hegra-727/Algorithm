package Daily.Oct2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 统计无向图中无法互相到达点对数2316 {
    //利用数组上list实现散列表
    private List<Integer>[] g;
    //记录数组，（记忆化）
    private boolean[] vis;
    public long countPairs(int n, int[][] edges) {
        g=new List[n];
        vis=new boolean[n];
        //构造g?
        Arrays.setAll(g,i->new ArrayList<>());
        for(int[] e:edges){
            int a=e[0],b=e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long ans=0,s=0;
        for (int i = 0; i < n; i++) {
            int t=dfs(i);
            ans+=s*t;
            s+=t;
        }
        return ans;
    }
    private int dfs(int i){
        if(vis[i])return 0;
        vis[i]=true;
        int cnt=1;
        for (int j:g[i])
            cnt+=dfs(j);
        return cnt;
    }
}
