package Daily.Nov2023;

public class 最长平衡子字符串2609 {
    /*public int findTheLongestBalancedSubstring(String s) {
        int t=0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            t|=1<<(ch-'0');
        }
    }*/

    //双指针匹配最小值+while中计数+最值计算
    public int findTheLongestBalancedSubstring(String s) {
        int idx=0;
        int len=s.length();
        int max=0;
        while(idx<len){
            int t1=0,t2=0;
            while(idx<len&&s.charAt(idx)=='0'&&t1++>=0)idx++;
            while(idx<len&&s.charAt(idx)=='1'&&t2++>=0)idx++;
            max=Math.max(max,Math.min(t1,t2)*2);
        }
        return max;
    }
}
