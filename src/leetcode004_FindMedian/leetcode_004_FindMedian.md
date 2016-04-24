# *题目*
**4. Median of Two Sorted Arrays**
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

#### 提交思路：
拿到这首题第反应就是大一C语言课上讲的思路：合并两个数组，然后再找出中位数。至于合并两个数组，则是一次遍历两个数组，按顺序依次将数据添加到一个新数组中，然后有剩余的一次性添加到新数组。按这种思路也就险过。。。囧
#### 提交代码：
```java
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] mergeNums = new int[nums1.length + nums2.length];
        int i, j,k;
        for(i = 0,j=0,k=0; i < nums1.length && j < nums2.length; k++)
        {
            if(nums1[i] > nums2[j])
            {
                mergeNums[k] = nums2[j];
                j++;
            }else
            {
                mergeNums[k] = nums1[i];
                i++;
            }
        }
        int[] tmp;
        if( i == nums1.length)
            tmp = Arrays.copyOfRange(nums2, j, nums2.length);
        else if (j == nums2.length)
            tmp = Arrays.copyOfRange(nums1, i, nums1.length);
        else
            tmp = new int[0];

        int m = 0;
        while(k < mergeNums.length)
            mergeNums[k++] = tmp[m++];

        int length = mergeNums.length;
        return length%2 == 0 ? (mergeNums[length/2-1]+mergeNums[length/2])*1.0/2 : mergeNums[length/2];
    }
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode004_FindMedian/img/1.png)
#### 提交总结：
从细节图来看，结果很不理想，不在可接受范围！！没有仔细设计算法。按照最普通的想法做出来 的。后来想了很久，这道题按照常规思维的话关键在合并两个数组上。要求时间复杂度要在O(log(m+n))。暂时还没什么好的想法，也许可以用递归求解，但还没找具体解法。
