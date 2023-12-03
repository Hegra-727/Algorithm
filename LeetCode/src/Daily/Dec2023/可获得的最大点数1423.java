package Daily.Dec2023;


import java.util.Arrays;

public class 可获得的最大点数1423 {
    public int maxScore(int[] cardPoints, int k) {
        //逆向思维出 求最小剩余的即可
        //滑动窗口大小为n-k，即最后剩余的长度
        int n=cardPoints.length;
        int windowSize=n-k;
        int sum=0;
        for (int i = 0; i < windowSize; i++) {
            sum+=cardPoints[i];
        }
        int minSum=sum;
        for (int i = windowSize; i < n; i++) {
            //滑动开始，左减右加
            sum+=cardPoints[i]-cardPoints[i-windowSize];
            minSum=Math.min(minSum,sum);
        }
        return Arrays.stream(cardPoints).sum()-minSum;
    }
}
