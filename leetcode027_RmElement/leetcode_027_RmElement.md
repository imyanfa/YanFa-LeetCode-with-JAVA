# *题目*
**27. Romove Element**  
Given an array and a value, remove all instances of that value in place and return the new length.  
Do not allocate extra space for another array, you must do this in place with constant memory.  
The order of elements can be changed. It doesn't matter what you leave beyond the new length.  
**Example:**  
Given input array nums = `[3,2,2,3]`, val = 3    
Your function should return length = 2, with the first two elements of nums being 2.  
**Hint:**    
1. Try two pointers.  
2. Did you use the property of "the order of elements can be changed"?  
3. What happens when the elements to remove are rare?

## 思路：
利用头尾两个指针，若头指针所指元素与val相等，则把尾指针所指元素移到头指针位置并向前移动尾指针，否则向后移动头指针。
## 代码：
```java
public int removeElement(int[] nums, int val)
{
    int endIndex = nums.length - 1;
    for(int i = 0; i <= endIndex; )
    {
        if(nums[i] == val)
            nums[i] = nums[endIndex--];
        else
            i++;
    }
    return endIndex + 1;
}
```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode027_RmElement/img/1.png)
