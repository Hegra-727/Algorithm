package Daily.Nov2023;

import java.util.ArrayList;
import java.util.List;

public class HTML实体解析器1410 {
    /*public String entityParser(String text){
        String[] s=text.split(" ");
        String[] html=new String[]{"&quot;","&apos;","&amp;","&gt;","lt;","&frasl;"};
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < html.length; j++) {
                if(s[i].equals(html[j])){
                    s[i]=html[j];
                }
            }
        }
        String res=new String();
        for(String s2:s){
            res+=s2+" ";
        }
        return res;
    }*/
    class EntityChar{
        String entity;
        char character;

        public EntityChar(String entity, char character) {
            this.entity = entity;
            this.character = character;
        }
    }
    List<EntityChar> entityCharList=new ArrayList<>();
    public String entityParser(String text){
        entityCharList.add(new EntityChar("&quot;", '"'));
        entityCharList.add(new EntityChar("&apos;", '\''));
        entityCharList.add(new EntityChar("&amp;", '&'));
        entityCharList.add(new EntityChar("&gt;", '>'));
        entityCharList.add(new EntityChar("&lt;", '<'));
        entityCharList.add(new EntityChar("&frasl;", '/'));
        StringBuffer res=new StringBuffer();
        int len=text.length();
        int pos=0;
        while(pos<len){
            boolean isEntity=false;
            //遇到&就开始进行检测
            if(text.charAt(pos)=='&'){
                for (EntityChar entityChar:entityCharList){
                    String e=entityChar.entity;
                    Character c=entityChar.character;
                    //在允许的条件下，检测字段是否和关键字相等
                    if(pos+e.length()<=text.length()&&text.substring(pos,pos+e.length()).equals(e)){
                        //追加指定的character,跳过原字符串？
                        res.append(c);
                        pos+=e.length();
                        isEntity=true;
                        break;
                    }
                }
            }
            if(!isEntity){
                res.append(text.charAt(pos++));
            }
        }
        return res.toString();
    }



}
