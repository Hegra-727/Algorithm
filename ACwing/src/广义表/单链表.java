package 广义表;

import java.util.Scanner;

public class 单链表 {
    static int N=100010;
    //e存值的数组、ne存下一个指向的下标、idx是当前下标、hh是头节点的下标
    static int e[]=new int[N],ne[]=new int[N],idx,hh=-1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n--!=0) {
            char ch=sc.next().charAt(0);
            if(ch=='H') {
                int x=sc.nextInt();
                add_head(x);
            }else if(ch=='I') {
                int k=sc.nextInt();
                int x=sc.nextInt();
                add(k-1,x);
            }else if(ch=='D') {
                int k=sc.nextInt();
                if(k==0)
                    hh=ne[hh];
                else
                    delete(k-1);
            }
        }

        for(int i = hh;i != -1;i = ne[i] ){  //本身就是-1了，怎么循环下去的？哪里改变了hh的初始值
            //题意是创建链表时，按插入先后的k个进行插入与删除，并非从左到右的第几个k进行
            System.out.print(e[i] +  " ");
        }
    }
    public static void add_head(int x) {
        e[idx]=x;
        ne[idx]=hh; //头插创建
        hh=idx++;
    }
    public static void add(int k,int x) {
        e[idx]=x;       //idx是当前节点，即插入的节点
        ne[idx]=ne[k];  //是ne[k],???是插入位置的下一个节点
        ne[k]=idx++;
    }
    public static void delete(int k) {
        ne[k]=ne[ne[k]];//删除
    }
}
