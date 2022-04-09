package ViolentRecursion;

public class Code_05IntegerBreak {
    public int integerBreak(int n){
        //dp[i] 为正整数 i 拆分后的结果最大乘积
        int[] dp = new int[n + 1];
        //n从2开始
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            //这里是在确定dp[i],只有遍历完才能确定最大值
            //dp[i - 1]已经确定了最大了，当前位置还没有确定
            //当前位置要确定 分成两个数（所有情况） 分成两个以上的数
            //从左往右遍历
            for (int j = 1; j < i - 1;j++){
                // j = 1  ---- 1 * (i - 1) ---- 1 * dp[i - 1]
                // j = 2  ---- 2 * (i - 2) ---- 2 * dp[i - 2]
                // j = i-2    (i-2)*2      ---- (i-2) *dp[2]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                        
            }
        }
        return dp[n];
    }
}
