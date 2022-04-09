package ViolentRecursion;

public class PalindromeSubsequence {
    //将自己逆序得到子串。再调用最长公共子序列
    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] str1 = s.toCharArray();
        int N = str1.length;
        char[] str2 = new char[N]; //卧槽？？？ 
        for (int i = N - 1; i >= 0; i--) {
            str2[i] = str1[N - i - 1];
        }
        return longestCommonSubsequence1(str1, str2);
    }

    public static int longestCommonSubsequence1(char[] str1, char[] str2) {

        int N = str1.length;//行
        int M = str2.length;//列
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
            } else {
                dp[row][0] = str2[0] == str1[row] ? 1 : 0;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = 0;
                if (str1[i] == str2[j]) {
                    p3 = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(Math.max(p1, p2), p3);
            }
        }
        return dp[N - 1][M - 1];
    }

    //暴力递归--------->DP  杰森
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length);
    }

    public int process(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return str[L] == str[R - 1] ? 2 : 1;
        }
        int p1 = process(str, L + 1, R - 1);
        int p2 = process(str, L, R - 1);
        int p3 = process(str, L + 1, R);
        int p4 = str[L] == str[R] ? process(str, L + 1, R - 1) + 2 : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public int longestPalindromeSubseq3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = 1;
        //basecase 填好 两条对角线
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        //正常情况 L=R是对角线  对角线已经过了两个了！
        for (int L = N - 3; L >= 0; L--){
            for (int R = L + 2; R < N; R++){
                int p1 = Math.max(dp[L][R - 1], dp[L + 1][R]);
                int p2 = str[L] == str[R] ? dp[L + 1][R - 1] + 2 : 0;
                dp[L][R] = Math.max(p1, p2);
            }
        }
        return dp[0][N - 1];
    }

}
