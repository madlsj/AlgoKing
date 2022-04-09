package ViolentRecursion;

public class Code_03MinCostClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        return Math.min(process(0, cost, N),process(1, cost, N));
    }
    //process返回从当前位置的走到底的最小花费
    public int process(int index, int[] cost, int N){
        if (index == N - 1){
            return cost[N - 1];
        }
        if (index == N - 2){
            return cost[N - 2];
        }
        //到当前位置 而且可以选择走两步也可以选择走一步
        
        //走一步
        int p1 = cost[index] + process(index + 1, cost, N);
        //走两步
        int p2 = cost[index] + process(index + 2, cost, N);
        return Math.min(p1, p2);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        dp[N - 1] = cost[N - 1];
        dp[N - 2] = cost[N - 2];
        if (N >= 3){
            for (int i = N - 3; i >= 0; i--){
                dp[i] = Math.min((cost[i] + dp[i + 1]), (cost[i] + dp[i + 2]));
            }
        }
        return dp[0] > dp[1] ? dp[1] : dp[0];
    }
    
    //走到当前位置的最小花费

}
