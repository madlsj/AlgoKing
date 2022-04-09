package ViolentRecursion;
//- 机器人必须走 K 步，最终能来到P位置的方法有多少种
//- 假设有一排的N个位置，N一定大于等于2，开始时候在M位置（1~N）位置上
public class robotWalk {
    public static int ways1(int N, int start, int aim, int K){
        if (N < 2 || start < 1 || start > N || aim < 1 ){
            return -1;
        }
        return process1(start, K, aim, N);
    }
    
    public static int process1(int cur, int rest, int aim, int N){
        //没有步数走了
        if (rest == 0){
            return cur == aim ? 1 : 0;
        }
        //还可以选择
        if (cur == 1){
            return process1(2, rest - 1, aim, N);
        }
        if (cur == N){
            return process1(N - 1, rest -1, aim, N);
        }
        return process1(cur - 1, rest -1, aim, N) + process1(cur + 1, rest - 1, aim, N);
        
    }
    //傻缓存
    public static int ways2(int N, int start, int aim, int K){
        if (N < 2 || start < 1 || start > N || aim < 1 ){
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int a = 0; a < dp.length; a++){
            for (int b = 0; b < dp[0].length; b++){
                dp[a][b] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }
    public static int process2(int cur, int rest, int aim, int N, int[][] dp){
        //已经算过了 
        if (dp[cur][rest] != -1){
            return dp[cur][rest];
        }
        //没有步数走了
        if (rest == 0){
            dp[cur][rest] = cur == aim ? 1 : 0;
            return dp[cur][rest];
        }
        //还可以选择
        if (cur == 1){
            dp[cur][rest] = process2(2, rest - 1, aim, N, dp);
            return dp[cur][rest];
        }
        if (cur == N){
            dp[cur][rest] = process2(N - 1, rest -1, aim, N, dp);
            return dp[cur][rest];
        }
        dp[cur - 1][rest - 1] = process2(cur - 1, rest -1, aim, N, dp) ;
        dp[cur + 1][rest - 1] = process2(cur + 1, rest -1, aim, N, dp);
        dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];  // 如果没有没有更新当前表的值
        return dp[cur][rest];

    }

    public static int ways3(int N, int start, int aim, int K){
        if (N < 2 || start < 1 || start > N || aim < 1 ){
            return -1;
        }
        //可变参数 cur rest
        int[][] dp = new int[N + 1][K + 1];
        //cur 1...N
        //rest 0...K
        //cur == 0 时候已经赋值好了 0
        dp[aim][0] = 1;
        //为什么从列开始循环 因为第一行和最后一行是额外计算，有了列变量后，好操作？少了很多判断
        for (int rest = 1; rest <= K; rest++){
            dp[1][rest] = dp[2][rest-1];
            for (int cur = 2; cur <= N - 1; cur++){
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }


        return dp[start][K]; 
//        for (int i = 1; i < dp.length; i++){
//            for (int j = 1; j < dp[0].length; j++){
//                if (i == 1){
//                    dp[1][j] = dp[2][j-1];
//                }
//                if (i == N){
//                    dp[i][j] = dp[N-1][j-1];
//                }
//                dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1];
//            }
//        }

    }
    
    
    public static void main(String[] args){
        System.out.println(ways1(5, 2, 4, 6));
        System.out.println(ways2(5, 2, 4, 6));
        System.out.println(ways3(5, 2, 4, 6));
    }
}
