package class01;

public class Code05_BSNearRight {
    //在arr上，找<=value的最右位置
    public static int nearestIndex(int[] arr, int value){
        int L = 0;
        int R = arr.length -1 ;
        int index = -1;//
        while (L <= R){
            int mid = L + ((R-L) >>1);
            if(arr[mid] <= value){ //找最右边，这里还满足，打个对勾！找最右，让L加啊
                index = mid;
                L = mid +1;
            }else {
                R = mid -1;
            }
        }
        return index;
    }

}
