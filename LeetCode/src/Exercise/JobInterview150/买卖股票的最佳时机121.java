package Exercise.JobInterview150;

public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
