package ViolentRecursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class hannoi {
    public void hannoi(int n){
        if (n > 0){
            func(n, "left", "right", "mid");
        }
    }
    public void func(int n, String from, String to, String other){
        if (n == 1){
            System.out.println("把1从"+ from + "移动到" + to);
        }
        func(n-1, from, other, to);
        System.out.println("把n从" + from + "移动到" + to);
        func(n - 1, other, to, from);
    }
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.size() > 0){
            f(A.size(), A, C, B);
        }
    }
    public void f(int n, List<Integer> from, List<Integer> to, List<Integer> other){
        if (n == 1){
            to.add(from.remove(from.size()-1));
            return;
        }
        f(n - 1, from, other, to);
        to.add(from.remove(from.size() - 1));
        f(n - 1, other, to, from);
    }

}

