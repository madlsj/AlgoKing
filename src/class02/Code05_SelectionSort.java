package class02;

public class Code05_SelectionSort {
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
        for(int i = 0 ; i  <arr.length-1 ; i++ ){ // 0~N-2的意思
            int minIndex = i; //从i开始即可
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
}
