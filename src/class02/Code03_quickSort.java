package class02;
/**
 * 经典快排每次只能找到一个数，且不稳定
 * 改进的快排
 * 左神喜欢用两个指针？
 */
public class Code03_quickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    //重载
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            swap(arr, (int) (left + Math.random()*(right-left+1)),right);
            int[] equalArea = partition(arr, left, right);
            quickSort(arr, left,equalArea[0] - 1);
            quickSort(arr, equalArea[1] + 1,right);
            quickSort(arr);
        }
        
    }
    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
