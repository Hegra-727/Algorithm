package Tmp;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        char[] ch=s.toCharArray();
        int[] coun=new int[130];
        int max=0;
        for (int i = 0,j=0; i < s.length(); i++) {
            coun[ch[i]]++;
            while(coun[ch[i]]>1){
                coun[ch[j++]]--;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}
