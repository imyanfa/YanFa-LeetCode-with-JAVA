# *题目*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.    

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).    

The replacement must be in-place, do not allocate extra memory.    

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.    

```

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

```

## 思路：
首先得搞清题目是啥意思。题目中文说直白一点就是给出一串数字的一个排列，找到这个排列的下一个排列(按数字大小顺序)。    
那么啥叫排列呢？比如数字1,2,3的全排列（所有排列）如下：    
```
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
```
那么，`1,2,3`的下一个排列就是`1,3,2`；`1,3,2`的下一个排列就是`2,1,3`；依次类推。如果给出的是最后一个也就是数字从大到小的顺序，那么就给出第一个排列，即顺序排列。     
再列举几个例子，为了避免与下标混淆，以下用字母代替数字元素：    
```
0  1  2  3   <--下标
A, B, C, D
A, B, D, C
A, C, B, D
A, C, D, B
A, D, B, C
A, D, C, B
B, A, C, D
.
.
.
```

以上为例，找出规律：     
假设排列数组名为nums    
1. 每次找下一个排列时，都是先从右向左找到第一个非降序排列的数，其下标记为p。比如第一个排列的p的位置为C所在位置，即下标2；第二个的排列的p的位置为B, 即下标1；`A, D, C, B`的p为下标0，即为A所在位置。  
2. 找到p之后，要作一次判断：若p的值为-1，也就是说没有非降序排列的数即此排列为最后一个排列，这时按题目的意思应该返回一个升序的排列，所以要将原数组重新排序。这里有一个技巧：原数组为有从大到小，现在要变为从小到大，那么只要以中间元素为中心，分别交换两边的元素：第一个与最后一个交换，第二个与倒数第二个交换，依次交换。  
3. 在p到最后一个元素之间找一个仅大于nums[p]的元素，其下标记为q。比如第一个排列的q的位置为D所在位置，即下标3；第二个的排列的q的位置为C, 即下标3；`A, D, C, B`的q为下标3，即为B所在位置。  
4. 交换nums[q]与nums[p]，这里可以用异或运算。  
5. 接下来只需要把p之后的所有元素顺序排序就行了。由于p后面的元素是从大到小排列的(思考p是怎样找到的就明白为什么了)，所以依然可以采用第二步的方法进行排序。  


## 代码：
```java
public void nextPermutation(int[] nums)
{
    //从右向左找到第一个非降序排列的数
    int p = nums.length - 2;
    while(p >= 0 && nums[p] >= nums[p + 1])
        p--;

    //判断若为全降序排列，则交换元素使数组成为全升序排列
    if(p == -1)
    {
        int tmp = nums.length - 1;
        for(int i = 0; i < nums.length / 2; i++)
        {
            nums[i] ^= nums[tmp - i];
            nums[tmp - i] ^= nums[i];
            nums[i] ^= nums[tmp - i];
        }
        return;
    }

    //在p与最后一个元素之间找到一个仅大于nums[p]的数（不能等于nums[p]）
    int q = nums.length - 1;
    while(q > p+1 && nums[q] <= nums[p])
        q--;

    //交换nums[p]与nums[q]
    nums[p] ^= nums[q];
    nums[q] ^= nums[p];
    nums[p] ^= nums[q];

    //将p之后的所有元素按顺序进行排序
    for(int i = p+1, j = nums.length-1; i < j ; i++,j--)
    {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode031_NextPermutation/img/1.png)

