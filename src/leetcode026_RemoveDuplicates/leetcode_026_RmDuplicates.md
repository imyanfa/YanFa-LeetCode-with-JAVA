# *题目*
**26. Remove Duplicates from Sorted Array**   
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.   
Do not allocate extra space for another array, you must do this in place with constant memory.   
 For example,    
Given input array nums = [1,1,2],    
 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
#### 思路：
核心思想为：**将不相等的元素向前移动，覆盖前面相等的元素。**  
步骤：先记下与上次元素不相等的位置k，然后向后遍历，一直到下一个不相等的元素下标记为i，然后将位置i的元素移到k+1的位置，此时修改k的值为k+1，重复以上步骤，直到数组遍历完毕。
#### 代码：
```java
public int removeDuplicates(int[] nums)
{
    if(nums.length == 0)
        return 0;
    int k = 0;
    for(int i = 1; i < nums.length;i++)
        if(nums[i] != nums[k])
            nums[++k] = nums[i];
    return k+1;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode026_RemoveDuplicates/img/1.png)
