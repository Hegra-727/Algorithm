package Daily.Oct2023;

import java.util.Arrays;
import java.util.Scanner;

public class 移动机器人2731 {
    static int[] num=new int[100010];
    static final int MOD=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n; i++) num[i]=sc.nextInt();
        String s=sc.nextLine();
        int distance=sc.nextInt();
        System.out.println(sumDistance(num,s,distance));
    }
    static int sumDistance(int[] num,String s,int d){
        //大小相等的位置数组，记录最终坐标情况。
        int n=num.length;
        int[] pos=new int[n];
        //1.对机器人进行移动
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='L')
                pos[i]=num[i]-d;
            else 
                pos[i]=num[i]+d;
        }
        //2.排序
        Arrays.sort(pos);
        //3.求两两之和
        long res=0;
        for (int i = 1; i < n; i++) {
            //贡献法？...
            res+= (long) (pos[i] - pos[i - 1]) * i %MOD*(n-i)%MOD;
            res%=MOD;
        }
        return (int)res;
    }
}
