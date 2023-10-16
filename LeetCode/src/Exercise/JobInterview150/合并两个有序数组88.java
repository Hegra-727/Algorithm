package Exercise.JobInterview150;

import java.util.Arrays;

public class 合并两个有序数组88 {
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int k=0;
        int[] ans=new int[nums1.length+nums2.length];
        while(i<=nums1.length&&j<=nums2.length){
            if(nums1[i]<nums2[j])
                ans[k++]=nums1[i++];
            else
                ans[k++]=nums2[j++];
        }
        while (i<=nums1.length)ans[k++]=nums1[i++];
        while (j<=nums2.length)ans[k++]=nums1[j++];
    }*/
    /*//尝试正向双指针+swap交换（临时存储），但是避免不了插入的O(n^2)时间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int len1=nums1.length,len2= nums2.length;
        while(i<len1&&j<len2){
            if(nums1[i]<nums2[j])
                i++;
            else {
                i++;
                int t=nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=t;
            }
        }
    }*/
    /*//填充空位+排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        *//*for (int i = nums1.length-1,j=0; i >=nums1.length-nums2.length; i++,j++) {
            nums1[i]=nums2[j];
        }*//*
        int i=0;
        int t=nums2.length;
        //1到nums2.length
        while(t--!=0){
            //nums1的末尾，同时非定义阶段的下标为 长度大小-1
            nums1[nums1.length-t-1]=nums2[i++];
        }
        Arrays.sort(nums1);
    }*/
    /*//临时空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[nums1.length];
        int i=0,j=0;
        int k=0;
        while(i<nums1.length-nums2.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp[k++]=nums1[i++];
            }else
                temp[k++]=nums2[j++];   //写成了nums1[j++]，调试发现错误滴！
        }
        while(i<nums1.length-nums2.length)temp[k++]=nums1[i++];
        while(j<nums2.length)temp[k++]=nums2[j++];
        for (int l = 0; l < nums1.length; l++) {
            nums1[l]=temp[l];
        }
    }*/

    //反向双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=nums1.length-nums2.length-1,j=nums2.length-1;
        int t=nums1.length-1;
        while(i>=0&&j>=0){  //0到length-1,或者1到length
            if(nums2[j]>nums1[i])
                nums1[t--]=nums2[j--];
            else
                nums1[t--]=nums1[i--];
        }
        while(j>=0)nums1[t--]=nums2[j--];   //目的就是合并两个数组，nums1可能为空，要补全遗漏的
    }
}
