package class01;

import java.util.Arrays;

/**
 * 在有序数组中找某个数是否存在
 */

public class Code04_BSExist {
    public static boolean exist(int[] sortedArr, int num){
        if(sortedArr == null || sortedArr.length ==0){
            return false;
        }

        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L)>>1);
            if(sortedArr[mid] == num){
                return true;
            }else if (sortedArr[mid] < num){
                L = mid + 1 ;
            }else {
                R = mid - 1 ;
            }
        }
        return sortedArr[L] == num ;
    }

    // for test

    public static boolean test(int[] sortedArr, int num){
        for(int cur : sortedArr){
            if(cur == num){
                return true;
            }
        }
        return false;
    }

    //生成多组随机样本的对数器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Fucking Nice!" : "Fucking fucked!");
    }
}
