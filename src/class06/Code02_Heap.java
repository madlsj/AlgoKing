package class06;

public class Code02_Heap {
    public class MyHeap{
        private int[] heap;
        private int limit;
        private int heapSize;
        //初始化
        public MyHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }
        //push操作
        public void push(int value){
            if (heapSize == limit){
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);

            
        }
        public void heapInsert(int[] arr, int index){
            int indexParent = (index - 1) / 2;
            while (indexParent != 0 && arr[indexParent] < arr[index]){
                swap(arr, index, indexParent);
                indexParent = (indexParent - 1 ) / 2;
            }
        }
        
        //pop操作
        public int pop(){
            if (heapSize == 0){
                throw new RuntimeException("heap is null");
            }
            int value = heap[0];//傻逼了 最大值在顶部！！
            swap(heap, 0, --heapSize);
            heapFy(heap, 0, heapSize);
            return value;
        }

        // 从index位置，往下看，不断的下沉
        // 停：较大的孩子都不再比index位置的数大；已经没孩子了
        public void heapFy(int[] arr, int index, int size){
            if (size == 0){
                return;
            }
            //看左右子树的最大值，和我比， 交换大的那个
            int leftIndex = index * 2 + 1;
            int largest = 0;
            while (leftIndex < size){
                //左右子树都在
               if (leftIndex + 1 < size){
                   // 先记录下标 一会要交换
                   largest = arr[leftIndex] > arr[leftIndex + 1] ? leftIndex : leftIndex + 1;
                   if (arr[index] >= arr[largest]){
                       break;
                   }
                   swap(arr, index, largest);
                   index = largest;
                   leftIndex = index * 2 +1 ;
               }else { //只有左 没有右
                   if (arr[index] >= arr[leftIndex]){
                       break;
                   }
                   swap(arr, index, leftIndex);
                   index = leftIndex;
                   leftIndex = index * 2 +1;
               }
               
            }
        }
        
        
        
        
        
        
        public void swap(int[] arr, int i, int j){
            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        
    }
   
}
