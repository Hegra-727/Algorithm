package Exercise.Template.分组循环;

public class 哪种连续子字符串更长1869 {
    /*public boolean checkZeroOnes(String s) {
        char[] ch=s.toCharArray();
        int[] count=new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[ch[i]-'0']++;
        }
        return count[1]>count[0];
    }*/
    /*public boolean checkZeroOnes(String s) {
        char[] ch=s.toCharArray();
        int len=s.length();
        if(len==1)return ch[0]=='1';
        int max0=0,max1=0;
        int fast=0;
        while(fast<len){
            int slow=fast;
            fast++;
            while(fast<len&&ch[fast]=='0'&&ch[fast]==ch[fast-1]){
                fast++;
            }
            max0=Math.max(max0,fast-slow);
            while(fast<len&&ch[fast]=='1'&&ch[fast]==ch[fast-1]){
                fast++;
            }
            max1=Math.max(max1,fast-slow);
        }
        return max1>max0;
    }*/


    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int[] cnt = new int[2];
        int i = 0;
        while(i < n) {
            int start = i;
            ++ i;
            while(i < n && s.charAt(i) == s.charAt(start)) {
                i ++;
            }
            cnt[s.charAt(start)-'0'] = Math.max(cnt[s.charAt(start)-'0'], i-start);
        }
        return cnt[1] > cnt[0];
    }

}
