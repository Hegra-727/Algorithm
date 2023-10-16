package ChapterOne.Array;

import java.util.Scanner;

public class 二分查找704 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(n);
    }
    //左闭右闭
    static int search1(int[] nums,int target){
        if(target<nums[0]||target>nums[nums.length-1])
            return -1;
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(r-l>>1)+l;
            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                r=mid-1;
            }else
                l=mid+1;
        }
        return -1;
    }
    //左闭右开
    static int search2(int[] nums,int target){
        if(target<nums[0]||target>nums[nums.length-1])
            return -1;
        int l=0,r=nums.length;//相当于给mid进一位了..
        while(l<r){
            int mid=(r-l>>1)+l; //对负数的位运算？测试显示无关..
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid] < target) {    //因为这块要反向收窄
                l=mid+1;
            }else
                r=mid;
        }
        return -1;
    }
}
