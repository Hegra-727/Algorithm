package Exercise.Template.分组循环;

public class 删除字符使字符串变好1957 {
    /*public String makeFancyString(String s){
        int len = s.length();
        char[] ch=s.toCharArray();
        int fast=0;
        int max=0;
        while(fast<len){
            int slow=fast;
            fast++;
            while(fast<len&&ch[fast]==ch[fast-1]){
                fast++;
            }
            max=Math.max(max,fast-slow);
            while(max>=3){

            }
        }
        return max
    }*/


    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length(), start = 0;
        while (i < n) {
            start = i;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1))
                i += 1;
            if (i > start) {
                sb.append(s.charAt(i));
            }
            sb.append(s.charAt(i));
            i += 1;
        }
        return sb.toString();
    }

}
