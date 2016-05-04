
# *题目*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.  
You may assume no duplicates in the array.  
Here are few examples.  
`[1,3,5,6]`, 5 → 2  
`[1,3,5,6]`, 2 → 1  
`[1,3,5,6]`, 7 → 4  
`[1,3,5,6]`, 0 → 0  
## 思路：
**二分查找**。若找到则返回找到的下标。否则返回left的值。
## 代码：
```java
public int searchInsert(int[] nums, int target)
{
    int left = 0, right = nums.length-1;
    while(left <= right)
    {
        int mid = (left + right)/2;
        if(nums[mid] < target)
            left = mid + 1;
        else if(nums[mid] > target)
            right = mid-1;
        else
            return mid;
    }
    return left;
}
```
## 结果细节（图）：




