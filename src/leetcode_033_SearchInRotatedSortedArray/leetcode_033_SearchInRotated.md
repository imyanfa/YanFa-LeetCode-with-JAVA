# *题目*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.  
(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).  
You are given a target value to search. If found in the array return its index, otherwise return -1.  
You may assume no duplicate exists in the array.  
## 思路：
**题目意思是**：有一个已经排好序的数组，但是这个数组从中间某一个点旋转了一下。给一个数，查找它在这个数组中的位置。  
**我的算法是**：先找出pivot所在位置，然后然后比较数组第一个数和target的大小，若nums[0] <= target，则在0至piovt+1之间用二分查找；否则在pivot+1至最后用二分查找。  
*说实话，我不明白这题目为什么会是hard级别的，就用最简单的直接查找也能在1ms完成。*
## 代码：
```java
public int search(int[] nums, int target)
{
    int pivot = 0;
    while(pivot < nums.length - 1 && nums[pivot] < nums[pivot + 1])
        pivot++;
    int res;
    if(nums[0] <= target)
        res = Arrays.binarySearch(nums,0,pivot+1,target);
    else
        res = Arrays.binarySearch(nums,pivot+1,nums.length,target);
    return res < 0 ? -1 : res;
}
```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode_033_SearchInRotatedSortedArray/img/1.png)


