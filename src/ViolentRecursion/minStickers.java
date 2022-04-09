package ViolentRecursion;

import java.util.HashMap;

public class minStickers {
    
    public static int minStickers1(String[] stickers, String target){
        int ans = process1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static int process1(String[] stickers, String target){
        if (target.length() == 0){//消耗零个剪纸 完毕
            return 0;
        }
        int min = Integer.MAX_VALUE; //最大值+1 等于负数
        //枚举 每次的rest字符串都用 不同的贴纸去尝试。走不同的分支
        for(String first : stickers){ //枚举不同分支
            String rest = minus(target, first);// 尽当前贴纸的力量去消减target
            if (target.length() != rest.length()){ //如果当前贴纸没消减、则不走这条分支！直接进入下一个分支的循环
                min = Math.min(min, process1(stickers, rest));//只是为了防止后面不可行的状态？ 这里其实就在开始走分支了
            }
            
        }
        // 该层过程中 min 已经抓住了。 如果min == MAX 证明 下面分支都走不通。证明这个点无效。
        //  相反有效的话。加上自己这一张纸 往上返回数量。
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
        
    }
    
    //用s2去消减s1 词频负的不管
    public static String minus(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] count = new int[26];// 0-'a' 1-'b'
        //词频统计
        for(char cha : str1){
            count[cha - 'a']++;
        }
        for (char cha : str2){
            count[cha - 'a']--;
        }
        //通过count构建字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            while (count[i] > 0){
                sb.append((char)(i + 'a'));
                count[i]--;
            }
        }
        return sb.toString();
    }
    
    
    public static int minStickers2(String[] stickers, String target){
        int N = stickers.length;
        //关键优化 用词频表代替贴纸数组
        int[][] counts = new int[N][26];
        for(int i = 0; i < N; i++){
            char[] str = stickers[i].toCharArray();
            for(char cha : str){
                counts[i][cha - 'a']++;
            }
        }
        int ans = process2(counts, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static int process2(int[][] stickers, String t){
        if (t.length() == 0){
            return 0;//消耗零个剪纸 完毕
        }
        //把target也变成词频表
        char[] target = t.toCharArray();
        int[] tCounts = new int[26];
        for(char cha : target){
            tCounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        //还是得枚举 贴纸 但是带着剪枝
        for (int i = 0; i < N; i++){
            int[] sticker = stickers[i];
            //最关键的优化(带有贪心思想，迟早要消减我的第一个字符)
            //restCha[0] - 'a' 第一个字符对应数组中的位置， 现在的贴纸要有能力消减！
            if (sticker[target[0] - 'a'] > 0){
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++){
                    if (tCounts[j] > 0){//目前剩余的字符
                        int nums = tCounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++){ //消减完还剩下的该字符
                            builder.append((char)(j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                //min其实是统计该分支下 后面的最小贴纸数
                min = Math.min(min, process2(stickers, rest));
            }
            
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
        
    }
    
    //傻缓存法！！！！
    public static int minStickers3(String[] stickers, String target){
        int N = stickers.length;
        //关键优化 用词频表代替贴纸数组
        int[][] counts = new int[N][26];
        for(int i = 0; i < N; i++){
            char[] str = stickers[i].toCharArray();
            for(char cha : str){
                counts[i][cha - 'a']++;
            }
        }
        //傻缓存法 
        //带着缓存做递归 
        //递归中返回值前面加入缓存 返回缓存表
        //傻缓存需要判断 但是主函数不变
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process3(counts, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp){
        if(dp.containsKey(t)){
            return dp.get(t);
        }
        
        if (t.length() == 0){
            dp.put(t, 0);
            return dp.get(t);//消耗零个剪纸 完毕
        }
        //把target也变成词频表
        char[] target = t.toCharArray();
        int[] tCounts = new int[26];
        for(char cha : target){
            tCounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        //还是得枚举 贴纸 但是带着剪枝
        for (int i = 0; i < N; i++){
            int[] sticker = stickers[i];
            //最关键的优化(带有贪心思想，迟早要消减我的第一个字符)
            //restCha[0] - 'a' 第一个字符对应数组中的位置， 现在的贴纸要有能力消减！
            if (sticker[target[0] - 'a'] > 0){
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++){
                    if (tCounts[j] > 0){//目前剩余的字符
                        int nums = tCounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++){ //消减完还剩下的该字符
                            builder.append((char)(j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                //min其实是统计该分支下 后面的最小贴纸数
                min = Math.min(min, process3(stickers, rest, dp));
            }

        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, ans);
        return dp.get(t);

    }

    public static void main(String[] args) {
        String[] stickers = new String[3];
        stickers[0] = "with";
        stickers[1] = "example";
        stickers[2] = "science";
        String target = new String("thehat");
        int x = minStickers3(stickers, target);
        System.out.println(x);

    }
}
