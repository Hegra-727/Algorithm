package Daily.Nov2023;

import java.util.HashMap;

public class 环和杆2103 {
    /*public int countPoints(String rings) {
        HashMap<Character, Integer> map=new HashMap<>();
        int res=0;
        for (int i = 0; i < rings.length(); i+=2) {
            map.put(rings.charAt(i),map.getOrDefault(map.get(rings.charAt(i)),1));
            if(map.get(rings.charAt(i))==3){
                res++;
            }
        }
        return res;
    }*/
    public int countPoints(String rings){
        char[] ch=rings.toCharArray();
        HashMap<Integer,HashMap<Character,Integer>> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,new HashMap<>());
        }
        for (int i = 0; i < ch.length; i+=2) {
            HashMap<Character,Integer> t=map.get(ch[i+1]-'0');  //遍历字符串，选中相应柱子的哈希表
            t.put(ch[i],t.getOrDefault(ch[i],0)+1);
        }
        int res=0;
        for (int i = 0; i < 10; i++) {
            if(map.get(i).size()==3){   //如果某柱子的哈希表的'键值对'有不同的3对，则res++
                res++;
            }
        }
        return res;
    }
}
