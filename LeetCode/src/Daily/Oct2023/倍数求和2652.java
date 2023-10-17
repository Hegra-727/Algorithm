package Daily.Oct2023;

public class 倍数求和2652 {
    /*public int sumOfMultiples(int n) {
        int sum=0;
        for (int i = 0; i <= n; i++) {
            if(i%3==0&&i%5==0&&i%7==0)
                sum+=i;
        }
        return sum;
    }*/

    //容斥原理
    public int sumOfMultiples(int n) {
        return fun(n,3)+fun(n,5)+fun(n,7)-fun(n,15)-fun(n,21)-fun(n,35)+fun(n,105);
    }
    public int fun(int n,int m){
        if(n<m)return 0;
        int k=n/m;//项数
        int a1=m;//首项
        int an=a1+(k-1)*m;//尾项
        return (a1+an)*k/2;
    }
}
