package Daily.Oct2023;

import java.util.Arrays;
import java.util.Scanner;

public class 最小和分割2578 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(SplitNum(n));
    }
    static int SplitNum(int num){
        char[] arr=String.valueOf(num).toCharArray();
        //忘记加上排序了
        Arrays.sort(arr);
        int num1 = 0,num2=0;
        for (int i = 0; i < arr.length; i++) {
            if(i%2==0)
                num1=num1*10+(arr[i]-'0');
            else
                num2=num2*10+(arr[i]-'0');
        }
        return num1+num2;
    }
}
