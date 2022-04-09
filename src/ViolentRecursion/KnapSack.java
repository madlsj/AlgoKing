package ViolentRecursion;

public class KnapSack {
    //没有负数 有可能等于0
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        //暴力递归 尝试 从左往右 直接返回递归值
        return process(w, v, 0, bag);
    }

    //从左往右尝试，左边的就锁住额
    //basecase
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {//rest=0 也有可能选
            return -1;
        }
        if (index == w.length) {
            return 0; //没得选了
        }
        //右边有货 且有剩余空间
        //但是有剩余空间这个货你也不一定能带走哦！！！！！！

        //没要当前的货
        int value1 = process(w, v, index + 1, rest);
        
        //想要
        int value2 = 0;
        int symbol = process(w, v, index + 1, rest - w[index]);
        if (symbol != -1){
            value2 = v[index] + process(w, v, index + 1, rest - w[index]);
        }
        
        return Math.max(value1, value2);
        
    }
    
    //傻缓存法
    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] map = new int[N + 1][bag + 1];
        //行和行有依赖，列和列没关系
        //从最后一行往上推。从左往右填列。
//        for (int j = 0; j <= bag; j++){
//            map[N][j] = 0;
//        }
        for (int index = N - 1; index >= 0; index--){
            for (int rest = 0; rest <= bag; rest++){
                int p1 = map[index + 1][rest];
                //等于0 也可以拿！！！！！！
                int p2 = rest - w[index] < 0 ?  0 : v[index] + map[index + 1][rest - w[index]];
                map[index][rest] = Math.max(p1, p2);
            }
        }
        
        return map[0][bag];
    }

    

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
