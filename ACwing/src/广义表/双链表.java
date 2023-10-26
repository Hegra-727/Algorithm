package 广义表;

import java.util.Scanner;

public class 双链表 {
    static int N=100010;
    static int[] e=new int[N],L=new int[N],R=new int[N];
    static int idx;

    public static void main(String[] args) {
        init();
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        while(m--!=0) {
            String ch=sc.next();    //写成了nextLine()了，吐血~~~,不熟悉api的下场！！
            if(ch.equals("L")) {

                int x=sc.nextInt();
                add(0,x);
            }else if(ch.equals("R")) {

                int x=sc.nextInt();
                add(L[1],x);
            }else if(ch.equals("D")) {

                int k=sc.nextInt();
                remove(k+1);
            }else if(ch.equals("IL")) {

                int k=sc.nextInt();
                int x=sc.nextInt();
                add(L[k+1],x);
            }else if(ch.equals("IR")) {

                int k=sc.nextInt();
                int x=sc.nextInt();
                add(k+1,x);
            }
        }
        for(int i=R[0];i!=1;i=R[i]) {
            System.out.print(e[i]+" ");
        }
    }


    public static void init() {
        R[0]=1;
        L[1]=0;
        idx=2;
    }
    //在第k个后，插入； 分别处理怎么出错了！！！？
    public static void add(int k,int x) {
        e[idx]=x;R[idx]=R[k];L[R[k]]=idx;R[k]=idx;L[idx]=k;idx++;
        //中心法，从右到左
        // e[idx]=x;
        // R[idx]=R[k];
        // L[idx]=k;
        // L[R[k]]=idx;
        // R[k]=idx++;
    }
    //删除第k个,分别拿左右节点去赋值
    public static void remove(int k) {
        R[L[k]]=R[k];
        L[R[k]]=L[k];
    }
}
