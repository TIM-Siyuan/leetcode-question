public class QuickSort3Ways{
    private QuickSort3Ways(){}

    private static void sort(Comparable[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机选取[l, r]的一个partition
        swap(arr, l, (int)(Math.random()*(r - l + 1)) + l);

        Comparable v= arr[l];

        //初始化时使得各个区间为空
        int lt = l;      // arr[l + 1...lt] < v
        int gt = r + 1;  // arr[gt...r] > v
        int i = l + 1;   // arr[lt + 1...i) == v
        while(i < gt){
            if(arr[i].compareTo(v) < 0){
                swap(arr, i, lt + 1);
                i++;
                lt++;
            }
            else if(arr[i].compareTo(v) > 0){
                swap(arr, i, gt - 1);
                gt--;
            }
            else{ // arr[i] == v
                i++
            }
        }

        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}