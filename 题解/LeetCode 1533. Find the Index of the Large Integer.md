## LeetCode 1533. Find the Index of the Large Integer

题目描述:

> We have an integer array `arr`, where all the integers in arr are **equal** except for **one integer which is larger** than the rest of the integers. You will not be given direct access to the array, instead, you will have an **API** ArrayReader which have the following functions:
>
> - `int compareSub(int l, int r, int x, int y)`: where 0 <= l, r, x, y < ArrayReader.length(), l <= r and x <= y. The function compares the sum of sub-array arr[l…r] with the sum of the sub-array arr[x…y] and returns:
>   **1** `if arr[l]+arr[l+1]+...+arr[r] > arr[x]+arr[x+1]+...+arr[y].`
>   **0** `if arr[l]+arr[l+1]+...+arr[r] == arr[x]+arr[x+1]+...+arr[y].`
>   **-1** `if arr[l]+arr[l+1]+...+arr[r] < arr[x]+arr[x+1]+...+arr[y].`
> - `int length()`: Returns the size of the array.
>
> You are allowed to **call compareSub() 20 times at most**. You can assume both functions work in O(1) time.
>
> Return the index of the array arr which has the largest integer.
>
> Follow-up:
>
> - What if there are two numbers in arr that are bigger than all other numbers?
> - What if there is one number that is bigger than other numbers and one number that is smaller than other numbers?



解题思路：

> 中间一分两半，保证两边的元素个数相同，然后调用compareSub方法，查看哪一部分的和更大，大数肯定在和更大的那半部分中。



代码：

```java
public int getIndex(ArrayReader reader) {
    int length = reader.length(); // 查看数组长度
    int l = 0,r = length-1; // 定义左右区间
    while(l < r){
        int mid = (l+r) / 2; // 中间位
        int res; 
        int count = r-l+1; 
        if(count % 2 == 0){ // 当前区间元素个数为偶数时
            res = reader.compareSub(l,mid,mid+1,r); // 比较两个区间
        }else{ // 当前区间元素个数为奇数时
            mid--; // 除去尾元素后等分当前区间
            res = reader.compareSub(l,mid,mid+1,r-1); // 比较两个区间
            if(res == 0) return r; // 两个区间相同时，大数一定是尾元素r
        }
        if(res == 1) r = mid; 
        else if(res == -1) l = mid + 1;
    }
    return l;
}
```

