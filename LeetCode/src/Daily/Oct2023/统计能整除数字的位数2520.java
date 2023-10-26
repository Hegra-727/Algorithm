package Daily.Oct2023;

public class 统计能整除数字的位数2520 {
    public int countDigits(int num) {
        //数位拆分计算，res结果数，temp临时存储
        int res=0;
        int temp=num;
        //temp作为除数，利用循环套temp/=10,加上temp%10取最后一位
        while(temp!=0){
            if(num%(temp%10)==0) res++;
            temp/=10;
        }
        return res;
    }
}
