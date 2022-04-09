package Array;

/**
 * 逆序对、理解为右边的小和问题。小何：[left,mid] [mid+1, right] 小河从左边开始！！
 *                         逆序对：从右边开始
 *剑指51.https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Code01_reversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int mergeSort(int[] arr, int left, int right){
        if (left <= right){
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
    }
    
    public int merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= right){
            res += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
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
class Solution {
    //利用归并排序解答，在合并的时候，当左边的大于右边，就计算逆序数。
    //计算公式； mid-left+1
    //定义一个全局的计数器变量
    int count = 0;
    public int reversePairs(int[] nums) {
        this.count = 0;
        mergeSort(nums, 0, nums.length-1);
        return count;
    }
    public void mergeSort(int[] nums,int left,int right){
        //当只有一个节点的时候，直接返回，退出递归
        if(left >= right){
            return;
        }
        int mid = (left+right)/2;
        //左拆分
        mergeSort(nums,left,mid);
        //右拆分
        mergeSort(nums,mid+1,right);
        //合并
        merge(nums,left,mid,right);
    }
    public void merge(int[] nums,int left,int mid,int right){
        //定义一个临时数组
        int[] temp = new int[right-left+1];
        //定义一个指针，指向第一个数组的第一个元素
        int i = left;
        //定义一个指针，指向第二个数组的第一个元素
        int j = mid+1;
        //定义一个指针，指向临时数组的第一个元素
        int t = 0;
        //当两个数组都有元素的时候，遍历比较每个元素大小
        while(i <= mid && j <= right){
            //比较两个数组的元素，取较小的元素加入到，临时数组中
            //并将两个指针指向下一个元素
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else{
                //当左边数组的大与右边数组的元素时，就对当前元素以及后面的元素的个数进行统计，
                //此时这个数就是，逆序数
                //定义一个计数器，记下每次合并中存在的逆序数。
                count += mid-i+1;
                temp[t++] = nums[j++];
            }
        }
        //当左边的数组没有遍历完成后，直接将剩余元素加入到临时数组中
        while(i <= mid){
            temp[t++] = nums[i++];
        }
        //当右边的数组没有遍历完成后，直接将剩余元素加入到临时数组中
        while(j <= right){
            temp[t++] =nums[j++];
        }
        //将新数组中的元素，覆盖nums旧数组中的元素。
        //此时数组的元素已经是有序的
        for(int k =0; k< temp.length;k++){
            nums[left+k] = temp[k];
        }
    }
}
