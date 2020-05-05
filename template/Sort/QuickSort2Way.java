public class QuickSort2Ways{
    private QuickSort2Ways(){}
    //双路快速排序的partition
    // 返回p, 使得arr[l...p-1] <= arr[p] ; arr[p+1...r] >= arr[p]
    // 双路快排处理的元素正好等于arr[p]的时候要注意，详见下面的注释：）
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot;
        // 这样更不容易退化成O(n^2)
        swap(arr, l, int(Math.random()*(r - l + 1)) + 1);
        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true){
            /*比如数组 1,0,0, ..., 0, 0
            a. 对于arr[i]<v和arr[j]>v的方式, 第一次partition得到的分点是数组中间;
            b. 对于arr[i]<=v和arr[j]>=v的方式, 第一次partition得到的分点是数组的倒数第二个.
            这是因为对于连续出现相等的情况, a方式会交换i和j的值; 而b方式则会将连续出现的这些值归为其中一方, 使得两棵子树不平衡
            */
            //遇到一个元素>=v时循环停止, 后续将i,j交换则左边范围为<=v; 但是此处判断不能<=, 原因如上
            while(i <= r && arr[i].compareTo(v) < 0)
                i++;
            //遇到一个元素<=v时循环停止, 后续将i,j交换则右边范围为>=v
            while(j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;

            //因为左区间设置为右开, 右区间设置为左开
            if(i > j)
                break;

            //交换i,j位置, 因为i, j都可能等于v
            swap(arr, i, j);
            i++;
            j--;
        }
        //将v摆到中间
        swap(arr, l, j);
        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}