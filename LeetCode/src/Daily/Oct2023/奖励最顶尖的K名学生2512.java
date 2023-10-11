package Daily.Oct2023;

import java.util.*;

public class 奖励最顶尖的K名学生2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }

    /*public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        //1. k计分 -> studentID -> report报告语句 -> feedback词汇
        //2. 遍历语句匹配词汇-计分 、ID分数键值对
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            k=0;//学生的分数+student_id[i]
            String[] s = report[i].split("");
            for (int j = 0; j < s.length; j++) {
                if(s[j].equals(positive_feedback[j]))
                    k+=3;
                else if(s[j].equals(negative_feedback[j]))
                    k-=1;
            }
            arrayList.add(student_id[i],k);
        }
        return arrayList;
    }*/
    //map映射、list映射坐标偏移、自定义排序
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        //1.feedback关键词与分数，map键值对
        Map<String,Integer> map=new HashMap<>();
//        Map<String,Integer> map2=new HashMap<>();
        for(String s:positive_feedback)map.put(s,3);
        for(String s:negative_feedback)map.put(s,-1);
        //2.遍历report字符串数组,拆出字符串和feedback进行一一匹配
        //计算每个report的分数
        int[] score=new int[report.length];
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            String[] words=report[i].split(" ");
            for(String s:words){
                if (map.containsKey(s))score[i]+=map.get(s);
//                if (map1.containsKey(s))score[i]-=1;
            }
//            arrayList.add(score[i]);
        }
//        //id数组、arraylist
         Integer[] id=new Integer[report.length];
        for (int i = 0; i < report.length; i++) id[i]=i;
//        //3.按照分数大小。学号大小自定义排序(针对id
        Arrays.sort(id,(a,b)->score[a]==score[b]?student_id[a]-student_id[b]:score[b]-score[a]);
//        //4.返回ArrayList根据3的排序写入分数,不要分数了，直接写条件面对id处理
        List<Integer> arr=new ArrayList<>();
        for (int i = 0; i < k; i++) arr.add(student_id[id[i]]);
        return arr;

        /*Integer[]id=new Integer[report.length];
        for(int i=0;i<report.length;i++)id[i]=i;
        Arrays.sort(id,(a,b)->score[a]==score[b]?student_id[a]-student_id[b]:score[b]-score[a]);
        List<Integer>arr=new ArrayList<>();
        for(int i=0;i<k;i++)arr.add(student_id[id[i]]);
        return arr;*/
    }
}