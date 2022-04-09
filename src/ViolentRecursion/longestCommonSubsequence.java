package ViolentRecursion;

public class longestCommonSubsequence {
    public static int longestCommonSubsequence1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = s1.length();//行
        int M = s2.length();//列
        int[][] dp = new int[N][M];
        //第一行一列的初始化
        for (int col = 0; col < M; col++) {
            if (col >= 1) {
                dp[0][col] = Math.max(str1[0] == str2[col] ? 1 : 0, dp[0][col - 1]);
            } else {
                dp[0][col] = str1[0] == str2[col] ? 1 : 0;
            }
        }
        for (int row = 0; row < N; row++) {
            if (row >= 1) {
                dp[row][0] = Math.max(str2[0] == str1[row] ? 1 : 0, dp[row - 1][0]);
            }else {
                dp[row][0] = str2[0] == str1[row] ? 1 : 0;
            }
        }
        //其他行 0 行 0列已经填完了 填dp[i][j] 
        // 四种可能性中最大的
        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = 0;
                if (str1[i] == str2[j]){
                    p3 = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(Math.max(p1, p2),p3);
            }
        }
        return dp[N - 1][M - 1];
    }
}
