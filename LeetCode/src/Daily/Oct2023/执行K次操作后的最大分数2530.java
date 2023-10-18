package Daily.Oct2023;

import java.util.*;

public class 执行K次操作后的最大分数2530 {
    /*public long maxKelements(int[] nums, int k) {
        Integer[] temp=new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i]=nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            hashMap.put(temp[i],hashMap.getOrDefault(temp[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            int key=entry.getKey(),value=entry.getValue();
            while(key--!=0){
                hashMap.put((int)Math.ceil(value/3),key);
            }

            hashMap.remove()
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            nums[i]= (int) Math.ceil(nums[i]);
        }
    }*/
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int num:nums)
            priorityQueue.offer(num);
        int ans=0;
        for (int i = 0; i < k; i++) {
            ans+=nums[i];
            priorityQueue.poll();
            priorityQueue.offer((nums[i]+2)/3);
        }
        return ans;
    }
}
