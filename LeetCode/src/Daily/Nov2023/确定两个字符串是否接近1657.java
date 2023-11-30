package Daily.Nov2023;

import java.util.Arrays;


public class 确定两个字符串是否接近1657 {
    public boolean closeStrings(String word1, String word2) {
        //1、长度不等，排除
        if(word1.length()!=word2.length())return false;
        int[] coun1=new int[26];
        int[] coun2=new int[26];
        for (char c1:word1.toCharArray())coun1[c1-'a']++;
        for (char c2:word2.toCharArray())coun2[c2-'a']++;
        //2、检查字符类型是否相同，有不同的字符则排除
        for(int i=0;i<26;i++){
            if(coun1[i]+coun2[i]==0)continue;
            if(coun1[i]==0||coun2[i]==0)return false;
        }
        Arrays.sort(coun1);
        Arrays.sort(coun2);
        //3、检查字符词频，词频不同则排除
        for (int i = 0; i < 26; i++) {
            if(coun1[i]!=coun2[i])
                return false;
        }
        return true;
    }
}
