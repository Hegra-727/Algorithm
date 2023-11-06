package Daily.Nov2023;

public class 最大单词长度乘积318 {
    public int maxProduct(String[] words) {
        //1、拆解string+字符运算
        //2、位运算压缩字符串中的字母状态,统一int 01串
        //3、比较不同的int压缩数字

        int[] array_k=new int[words.length];
        int res=0;
        for (int i = 0; i < words.length; i++) {
            int k=0;
            for (int j = 0; j < words[i].length(); j++) {
                int t=words[i].charAt(j)-'a';
                k|=(1<<t);
            }
            array_k[i]=k;
        }
        for (int i = 0; i < array_k.length; i++) {
            for (int j = 0; j < i; j++) {
                if((array_k[i]&array_k[j])==0)
                    res=Math.max(res,words[i].length()*words[j].length());
            }
        }
        return res;
    }
}
