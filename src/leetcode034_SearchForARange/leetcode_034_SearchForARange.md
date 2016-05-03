# *题目*
Given a sorted array of integers, find the starting and ending position of a given target value.    
Your algorithm's runtime complexity must be in the order of $O(\log n)$.    
If the target is not found in the array, return `[-1, -1]`.  
For example,  
Given `[5, 7, 7, 8, 8, 10]` and target value 8,  
return `[3, 4]`.  
## 思路：
二分查找。先在整个数组中进行二分查找，找到target的某一个位置，然后在这个位置的前后进行查找确定范围。  
在进行查找范围时也是用的二分查找的思想，但是和传统二分查找有点区别：比如找到某一个target位置，现在要向前查找确定范围下界，那么就是要向前查找第一个不等于target的数，向后也是一样。
## 代码：
```java
public int[] searchRange(int[] nums, int target)
{
    int[] res = new int[]{-1, -1};

    //在nums中进行二分查找，找到target的某一个位置
    //然后在这个位置前后进行范围查找
    int left = 0, right = nums.length - 1;
    while(left <= right)
    {
        int mid = (left + right) / 2;
        if(nums[mid] == target)
        {
            //寻找下界
            int p = left, q = mid - 1;
            while(p <= q)
            {
                int r = (p + q) / 2;
                if(nums[r] == target)
                    q = r - 1;
                else
                    p = r + 1;
            }
            res[0] = q + 1;

            //寻找上界
            p = mid + 1;
            q = right;
            while(p <= q)
            {
                int r = (p + q) / 2;
                if(nums[r] == target)
                    p = r + 1;
                else
                    q = r - 1;
            }
            res[1] = p - 1;
            break;
        } else if(nums[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return res;
}
```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode034_SearchForARange/img/1.png)



