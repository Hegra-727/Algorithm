package Exercise.Template.分组循环;

public class 连续字符1446 {
    public int maxPower(String s) {
        char[] ch=s.toCharArray();
        int len=s.length();
        int fast=0;
        int max=0;
        while(fast<len){
            int slow=fast;
            fast++;
            while(fast<len&&ch[fast-1]==ch[fast]){
                fast++;
            }
            max=Math.max(max,fast-slow);
        }
        return max;
    }
}
