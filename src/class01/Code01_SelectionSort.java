package class01;

import java.util.Arrays;

public class Code01_SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2 ){
            return;
        }
        // 0~ N-1 找到最小值，在哪，放到0位置上
        // 1~ N-1 找到最小值，在哪，放到1位置上
        // 2~ N-1 找到最小值，在哪，放到2位置上
        // N-2~ N-1 找到最小值，在哪，放到N-2位置上
        //小于谁，访问不到那个位置的，只能访问到那个值前一个位置的值。
        //累积执行了N-1次。 每一次中进行比较交换！(交换就要记录一个index)
        for(int i = 0 ; i  <arr.length-1 ; i++ ){
            int minIndex = i;
            for (int j = i +1 ; j < arr.length ; j++){ //找出 i ~ N-1中最小值的下标
                if(arr[j]<arr[minIndex]){
                    minIndex = j ;
                }
            swap(arr, i , minIndex);
            }
        }
    }

    public static void swap(int[]arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Fucking Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }



}
