package Daily.Nov2023;

import java.util.ArrayDeque;
import java.util.Deque;

public class 子数组的最小值之和907 {
    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // 注：推荐用 ArrayDeque 实现栈
        st.push(-1); // 方便赋值 left
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                st.pop(); // 移除无用数据
            left[i] = st.peek();
            st.push(i);
        }

        // 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        int[] right = new int[n];
        st.clear();
        st.push(n); // 方便赋值 right
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 1 && arr[st.peek()] > arr[i])
                st.pop(); // 移除无用数据
            right[i] = st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i); // 累加贡献
        return (int) (ans % MOD);
    }
}
