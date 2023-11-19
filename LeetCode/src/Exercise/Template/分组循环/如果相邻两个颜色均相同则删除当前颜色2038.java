package Exercise.Template.分组循环;

public class 如果相邻两个颜色均相同则删除当前颜色2038 {
    /*public boolean winnerOfGame(String colors){
        char[] ch=colors.toCharArray();
        int len=colors.length();
        int fast=0;
        int[] cnt=new int[2];
        int max=0;
        while (fast<len){
            if(fast==0||fast==len-1) {
                fast++;
                continue;
            }
            int slow=fast;
            fast++;
            while(fast<len&&ch[fast]==ch[fast-1]){
                fast++;
            }
            cnt[ch[fast]-'A']=Math.max(cnt[ch[fast]-'A'],fast-slow);
            cnt[ch[fast]-'A']--;
        }
        return cnt[0]>1;
    }*/
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0, n = colors.length();
        int[] cnt=new int[2];
        for (int i = 0; i < n; ++i) {
            int start = i;
            while (i + 1 < n && colors.charAt(i + 1) == colors.charAt(i)) i++;
            cnt[colors.charAt(start)-'A']+=Math.max(i-start-1,0);
//            if (colors.charAt(start) == 'A') a += Math.max(i - start - 1, 0);
//            if (colors.charAt(start) == 'B') b += Math.max(i - start - 1, 0);
        }
        return cnt[0]>cnt[1];
    }
}
