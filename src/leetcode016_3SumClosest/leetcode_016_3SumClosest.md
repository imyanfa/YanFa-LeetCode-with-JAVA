# *题目*
**16. 3Sum Closest**    
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

```

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

```

#### 思路：
从target入手，首先找最符合target的，即target就在给定的数组里，然后依次target+1, target-1,target+2, target-2....比较下去，直到找到结果。
#### 代码：
```java
public int threeSumClosest(int[] nums, int target)

{

    Arrays.sort(nums);

    int[] flags = {-1, 1}; //实现+1，-1，+2，-2的效果必要数组

    for(int a = 0; ; a++)  //target加的自增长变量

    {

        for(int b = 0; b < 2; b++)//循环两次，第一次实现target-a，第二次实现target+a

        {

            //下面的就是常规的找

            int _target = target + a * flags[b];

            for(int c = 0; c < nums.length - 2; c++)

            {

                int low = c+1;

                int high = nums.length-1;

                while(low < high)

                {

                    int sum = nums[c] + nums[low] + nums[high];

                    if(sum == _target) return _target;

                    if(sum < _target) low++;

                    else if(sum > _target) high--;

                }

            }

        }

    }

}

```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode016_3SumClosest/img/1.png)