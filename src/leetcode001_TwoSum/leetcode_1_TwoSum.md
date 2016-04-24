# *题目*
**1. Two Sum**  
Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.
You may assume that each input would have *exactly* one solution.

**Example:**
```
Given nums = [2, 7, 11, 15], target = 9,
 
Because nums[0] + nums[1] = 2 + 7 = 9, 
return [0, 1].
```
# *第一次提交*
#### 第一次提交代码：
```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = i+1; j< nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }
        //不加这句会有语法错误
        return new int[]{-1,-1};
    }
}
```
#### 第一次结果细节：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode001_TwoSum/img/1.png)
#### 第一次提交总结：
虽然结果是AC，但是从Submission Details可以看出结果并不理想。本次提交并未用任何算法，纯靠循环硬解，效率可想而知。

# *第二次提交*
#### 第二次提交代码：
```java
public class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        //map用来记录原数组的值与下标的关系
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++ )
            map.put(i,nums[i]);

        //对数组进行排序
        Arrays.sort(nums);

        //得到目标值数组
        List<Integer> targerNumbers = new ArrayList<>();

        int[] targerIndex = new int[]{-1,-1};

        {
            //核心代码
            int i=0, j = length-1;
            while(i < j)
            {
                int tmp = nums[i]+nums[j];
                if(tmp == target)
                {
                    targerNumbers.add(nums[i]);
                    targerNumbers.add(nums[j]);
                    break;
                }else if(tmp < target)
                    i++;
                else
                    j--;
            }
        }
        //返回目标下标
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue().equals(targerNumbers.get(0)) && targerIndex[0]==-1)
                targerIndex[0] = entry.getKey();
            else if(entry.getValue().equals(targerNumbers.get(1)) && targerIndex[1]==-1)
                targerIndex[1] = entry.getKey();

        }
        return targerIndex;
    }
}
```
#### 第二次结果细节：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode001_TwoSum/img/2.png)
#### 第一次提交总结：
效率有提升，但仍不理想。思路：先把输入数组排序，核心算法是用两个指针向中间走。

# *第三次提交*
#### 第三次提交代码：
```java
public class Solution 
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] targerIndex = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                targerIndex[0] = map.get(nums[i]);
                targerIndex[1] = i;
                break;
            } else
            {
                map.put(target - nums[i], i);
            }
        }
        return targerIndex;
    }
}
```
#### 第三次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode001_TwoSum/img/3.png)
#### 第三次提交总结：
这次效率得到巨大提升。本次提交参考了[vtkrishn](https://leetcode.com/discuss/90368/my-6ms-java-solution)的代码。
