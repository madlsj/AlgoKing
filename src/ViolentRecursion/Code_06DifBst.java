package ViolentRecursion;

public class Code_06DifBst {
    public int numTrees(int n){
        //初始化dp数组 i个节点时候返回的最大BST数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //依赖头 从小到大 dp[i - 1]已经确定了
        for (int i = 2; i <= n; i++){
            //确定dp[i]
            //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
            //因为是BST
            // 一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
            for (int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j]; 
            }
        }
        return dp[n];
    }
}
