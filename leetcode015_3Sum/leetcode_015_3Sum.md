# *题目*
**15. 3 Sum**  
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.    
**Note:**      
- Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)  
- The solution set must not contain duplicate triplets.  
```
For example, given array S = {-1 0 1 2 -1 -4},
 A solution set is:
(-1, 0, 1)
(-1, -1, 2)
```
#### 思路：
我用了一种最笨的方法：用三个循环硬解。当然如果什么都不处理，肯定是会TLE的。我先把数组用Arrays的sort方法排序，然后再循环的过程中如果前后元素相同则跳过。
#### 代码：
```java
public List<List<Integer>> threeSum(int[] nums)
{
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    for(int i = 0; i < nums.length; i++)
    {
        for(int j = i + 1; j < nums.length; j++)
        {
            for(int k = j + 1; k < nums.length; k++)
            {
                if(nums[i] + nums[j] + nums[k] == 0)
                {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                while(k+1 < nums.length&& nums[k] == nums[k+1])
                    k++;
            }
            while(j+1 < nums.length&& nums[j] == nums[j+1])
                j++;
        }
        while(i+1 < nums.length&& nums[i] == nums[i+1])
            i++;
    }
    return lists;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode015_3Sum/img/1.png)
# *总结：*
这个方法还是有一定机率会出现TLE的，但是现在还没什么好的办法。以后想到了再补充。
