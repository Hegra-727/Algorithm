package Daily.Nov2023;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 无限集中的最小数字2336 {
    class SmallestInfiniteSet {
        Set<Integer> set = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = 1; // n为非离散区间的起始位置
        public SmallestInfiniteSet() {
        }

        public int popSmallest() {
            if (set.isEmpty()) return n++;
            int res = pq.poll();
            set.remove(res);
            return res;
        }

        public void addBack(int num) {
            if (num < n && set.add(num)) pq.add(num);
        }
    }
}
