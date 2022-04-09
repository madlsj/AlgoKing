import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class test {
    public static void main(String[] args) {
        System.out.println('a'-'b');
    }
        
}
class Solution {
    public int numDistinct(String s, String t) {
        List<String> substring = subs(t);
        int nums = 0;
        for(String x : substring){
            if(x.equals(s)){
                nums++;
            }
        }
        return nums;

    }
    //先获得t的全部子序列
    public List<String> subs(String s){
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process(str, 0, ans, path);
        return ans;
    }


    public void process(char[] str, int index, List<String> ans, String path){
        if(index == str.length){
            ans.add(path);
            return;
        }
        process(str, index + 1, ans, path);
        process(str, index + 1, ans, path + String.valueOf(str[index]));
    }
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.size() > 0){
            f(A.size(), A, C, B);
        }
    }
    public void f(int n, List<Integer> from, List<Integer> to, List<Integer> other){
        if (n == 1){
            to.add(from.remove(from.size()-1));
            //return;
        }else {
            f(n - 1, from, other, to);
            to.add(from.remove(from.size() - 1));
            f(n - 1, other, to, from);
        }

    }

}
