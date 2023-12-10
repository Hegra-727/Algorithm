package Tmp;

import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            //排序
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            //针对list进行追加扩充
            String s=new String(ch);
            List<String> list=map.getOrDefault(s,new ArrayList<String>());
            //结果格式处理
            list.add(str);
            map.put(s,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
