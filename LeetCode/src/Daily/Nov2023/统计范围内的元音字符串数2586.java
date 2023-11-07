package Daily.Nov2023;

public class 统计范围内的元音字符串数2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int res=0;
        for (int i = left; i <= right; i++) {
            char ch=words[i].charAt(0);
            char ch2=words[i].charAt(words[i].length()-1);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                if(ch2=='a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u')
                    res++;
        }
        return res;
    }
}
