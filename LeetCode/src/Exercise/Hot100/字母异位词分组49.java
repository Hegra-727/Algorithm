package Exercise.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 字母异位词分组49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            char[] ch= str.toCharArray();
            Arrays.sort(ch);
            //键的信息（String类型）
            String key=new String(ch);
            //值的信息（List列表）
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            //填充数据
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
