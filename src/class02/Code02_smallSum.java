package class02;

import java.util.Arrays;

/**
 * 小和----逆向思维
 * 右边有几个数比我大，利用归并排序。组内都生成过小和了，组内有序。
 * 主要关注点：以左边为主体！相等的话，右边近辅助数组，就不会少算。
 */
public class Code02_smallSum {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    public static int mergeSort(int[] arr, int left, int right){
        if (left == right){
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
    }
    
    public static int merge(int[] arr, int left, int mid, int right){
        int [] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= left && p2 <= right){
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= left){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
        return res;
    }
}
