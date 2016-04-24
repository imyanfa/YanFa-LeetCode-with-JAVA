# *题目*
**18. 4 Sum**  
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.  
*Note:*  
- Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)  
- The solution set must not contain duplicate quadruplets.  
```
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.    
A solution set is:    
(-1,  0, 0, 1)    
(-2, -1, 1, 2)    
(-2,  0, 0, 2)
```
#### 思路：
根据3Sum进行改进。

#### 代码：
```java
public List<List<Integer>> fourSum(int[] nums, int target)
{
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    for(int i = 0; i < nums.length - 3; i++)
    {
        if(i == 0 || nums[i] != nums[i - 1])
        {
            for(int j = i+1; j < nums.length-2; j++)
            {
                if(j == i+1 || nums[j] != nums[j-1])
                {
                    int low = j+1;
                    int high = nums.length-1;
                    int sum = target-nums[i] -nums[j];
                    while(low < high)
                    {
                        if(nums[low]+nums[high] == sum)
                        {
                            lists.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                            while(low < high && nums[low] == nums[low+1]) low++;
                            while(low < high && nums[high] == nums[high-1]) high--;
                            low++;high--;
                        }
                        else if (nums[low] + nums[high] < sum) low++;
                        else high--;
                    }
                }
            }
        }
    }
    return lists;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode018_4Sum/img/1.png)