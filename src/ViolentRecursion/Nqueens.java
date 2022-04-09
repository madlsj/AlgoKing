package ViolentRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {
    //计算数量
    public static int totalNQueens(int n) {
        if (n == 1){
            return 1;
        }
        int[] record = new int[n];
        return process(record, 0, n);
    }
    //递归过程
    public static int process(int[] record, int index, int n){
        //深度优先遍历这条道走得通
        //这就是一种方法！证明递归中要累加!
        if (index == n){
            return 1;
        }
        //假设当前分支及其子分支都走不通！
        int res = 0;
        //判断当前分支======能否创建子分支进行深度优先
        
        //剪枝处理 
        for (int col = 0; col < n; col++){
            if (isValid(record, index, col)){
                //因为这是个for 循环，要累加res ！
                //那么考虑当前节点是不是其他的for循环？ 
                //想象第一行的样子
                record[index] = col;
                res = res + process(record, index + 1, n);
                //为什么不恢复现场
            }
        }
        return res;
    }
    //判断当前位置和 0...index - 1 行的冲突与否=========不共列 斜率不等于1
    public static boolean isValid(int[] record, int i, int j){
        for (int k = 0; k < i; k++){
            //Math.abs(k - i) == Math.abs(record[k] - j)
            //谨慎用除法！！！！
            if (j == record[k] || Math.abs((k - i) / (record[k] - j)) == 1){
                return false;
            }
        }
        return true;
        
    }
    
    public static void main(String[] args){
        int n = 15;
        
        System.out.println(totalNQueens(15));
    }
}
class Solution {
    //最终要返回的多个解的集合
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //棋盘二维数组
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        //从0行开始
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        //0...n-1 行已经填完了。那么证明这是一种解法。
        if (row == n) {
            res.add(Array2List(chessboard));//将当前char数组棋盘转换为要求的 List<String>
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q'; //看这个位置能不能放Q
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.'; //恢复现场
            }
        }

    }

    //将二维char数组转换为List<String>
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c)); //直接一行一行变吗？
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列 ...到row - 1 
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}


