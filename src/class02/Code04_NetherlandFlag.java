package class02;

public class Code04_NetherlandFlag {
    //前情提要，一个数组arr，一个数组num，小于等于num放左边，大于num放右边
    //1.用哨兵结点dummy = -1，标记小于区域最后一个位置，
    //2.for循环依次遍历数组中的数字，大于指定数字则跳过，小于等于的话，交换且，让dummy加一个。
    public static void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int[] sortBynum(int[] arr, int num){
        int dummy = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= num){
                swap(arr, i, ++dummy);
            }
        }
        return arr;
    }
    //荷兰国旗 0 1 2 这样是错误的，大指针动的时候，数组指针不能动，小指针动的时候数组指针需要动，且判断条件是到大指针！！
    //==============================================================================================
    public void sortColorsFalse(int[] nums) {
        int dummyLeft = -1;
        int dummyRight = nums.length;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                swap(nums, i, ++dummyLeft);
            }else if (nums[i] == 2){
                swap(nums, i, --dummyRight);
            }
        }
    }
    //三个指针
    //为什么触发大区域时候，i指针不能动，因为换过来的数字是没看过的
    public void sortColors(int[] nums){
        int less = -1;
        int more = nums.length;
        int i = 0;
        //必须 if elseif else  要不然一直++
        while (i < more){
            if (nums[i] > 1){
                swap(nums, i, --more);
            }else if (nums[i] < 1){
                swap(nums, i, ++less);
                i++;
            }else {
                i++;
            }
        }
    }
    
    
    
}
