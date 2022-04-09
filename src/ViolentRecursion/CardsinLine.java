package ViolentRecursion;

public class CardsinLine {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }
    public static int first(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int score1 = arr[L] + second(arr, L + 1, R);
        int score2 = arr[R] + second(arr, L, R - 1);
        return Math.max(score1, score2);
    }
    
    public static int second(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int score1 = first(arr, L + 1, R);
        int score2 = first(arr, L, R - 1);
        return Math.min(score1, score2);
    }
    
    //傻缓存法 不改变返回值 和 递归函数
    //可变参数LR 两张表即可LR
    public static int win2(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fDp = new int[N][N];
        int[][] sDp = new int[N][N];
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sDp[i][j] = -1;
                fDp[i][j] = -1;
            }
        }
        int firstScore = first2(arr, 0, N - 1, fDp);
        int secondScore = second2(arr, 0, N - 1, sDp);
        return Math.max(firstScore, secondScore);
    }
    public static int first2(int[] arr, int L, int R, int[][]fDp){
        //遇到过了
        if (fDp[L][R] != -1){
            return fDp[L][R];
        }
        //没遇到过
        if (L == R){
            fDp[L][R] = arr[L];
            return fDp[L][R];
        }
        int score1 = arr[L] + second(arr, L + 1, R);
        int score2 = arr[R] + second(arr, L, R - 1);
        fDp[L][R] = Math.max(score1, score2);
        return fDp[L][R];
    }

    public static int second2(int[] arr, int L, int R, int[][]sDp){
        if (sDp[L][R] != -1){
            return sDp[L][R];
        }
        if (L == R){
            sDp[L][R] = 0;
            return sDp[L][R];
        }
        int score1 = first(arr, L + 1, R);
        int score2 = first(arr, L, R - 1);
        sDp[L][R] = Math.min(score1, score2);
        return sDp[L][R];
    }

    public static int win3(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fDp = new int[N][N];
        int[][] sDp = new int[N][N];
        for (int i = 0; i < N; i++){
            fDp[i][i] = arr[i];
        }
//        for (int row = 0; row < N; row++){
//            for (int col = row + 1; col < N; col++)
//        }
        //斜线动态规划
        for(int startCol = 1; startCol < N; startCol++){
            //每次都从零行开始
            int row = 0;
            int col = startCol;
            while (col < N){
                fDp[row][col] = Math.max(arr[row] + sDp[row + 1][col], arr[col] + sDp[row][col - 1]);
                sDp[row][col] = Math.min(fDp[row + 1][col], fDp[row][col - 1]);
                row++;
                col++; 
            }
        }
        int firstScore = fDp[0][N - 1];
        int secondScore = sDp[0][N - 1];
        return Math.max(firstScore, secondScore);
    }


    public static void main(String[] args) {
        int[] arr = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
