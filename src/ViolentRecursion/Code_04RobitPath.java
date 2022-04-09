package ViolentRecursion;

public class Code_04RobitPath {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1){
            return 1;
        }
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++){
            dp[0][j] = 1;
        }
        //从上往下、从左往右
        for (int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
        
    }
    //if obstacleGrid[][] == 1 终止初始化和DP赋值
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }
        for (int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                if (obstacleGrid[row][col] == 1){
                    continue;
                }
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}

