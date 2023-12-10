package Tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有的字母异位词 {
    public List<Integer> findAnagrams(String s,String p){
        int n=s.length(),m=p.length();
        List<Integer> list=new ArrayList<>();
        if(n<m) return list;
        int[] s_cnt=new int[26];
        int[] p_cnt=new int[26];
        char[] ch=s.toCharArray();
        //频次采集+首次判断
        for (int i = 0; i < m; i++) {
            s_cnt[ch[i]-'a']++;
            p_cnt[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(s_cnt,p_cnt))
            list.add(0);
        //滑动窗口式匹配
        for(int i=m;i<n;i++){
            s_cnt[ch[i-m]-'a']--;
            s_cnt[ch[i]-'a']++;
            if(Arrays.equals(s_cnt,p_cnt))
                list.add(i-m+1);
        }
        return list;
    }
}
