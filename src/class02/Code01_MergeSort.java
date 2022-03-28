package class02;

public class Code01_MergeSort {
    
    //递归方法实现
    public static void  mergeSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0 , arr.length-1);
    }
    
    public static void process(int[] arr, int L ,int R){
        if(L==R){ //base case
            return;
        }
        
    }
    
}
