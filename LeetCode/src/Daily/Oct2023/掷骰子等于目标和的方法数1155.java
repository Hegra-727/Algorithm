package Daily.Oct2023;

import java.util.Arrays;

public class 掷骰子等于目标和的方法数1155 {
    private static final int MOD = 1_000_000_007;
    //记忆化搜索
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0; // 无法组成 target
        }
        int[][] memo = new int[n + 1][target - n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1); // -1 表示没有计算过
        }
        return dfs(n, target - n, memo, k);
    }

    private int dfs(int i, int j, int[][] memo, int k) {
        if (i == 0) {
            return j == 0 ? 1 : 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        for (int x = 0; x < k && x <= j; x++) { // 掷出了 x
            res = (res + dfs(i - 1, j - x, memo, k)) % MOD;
        }
        return memo[i][j] = res; // 记忆化
    }
}
