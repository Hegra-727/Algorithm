package Exercise.JobInterview150;

public class 买卖股票的最佳时机II122 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int sum=0;
        int profit=-prices[0];
        for (int i = 0; i < prices.length; i++) {
            sum=Math.max(sum,profit+prices[i]);
            profit=Math.max(profit,sum-prices[i]);
        }
        return sum;
    }
}
