# *题目*
**11. Container With Most Water**  
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.  

Note: You may not slant the container.

#### 提交思路：
利用左右两个指针分别向中间移动，计算两个指针之间的面积，记下大的。两指针的移动规则：若左边的height值大则移右边的，相反，若右边的height值大则移左边的。（原因：因为要求装最多的水，那么肯定要记下相对较矮的一边）。
#### 提交代码：
```java
public int maxArea(int[] height)
{
   int left=0, right=height.length-1;
   int max = 0;
   while(left < right)
   {
       int tmp;
       if(height[left] < height[right])
           tmp = (right-left)*height[left++];
       else
           tmp= (right-left)*height[right--];
       max = Math.max(max,tmp);
   }
   return max;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode011_ContainerWithMostWater/img/1.png)
# *总结：*
开始我想用两个for循环嵌套来解决（最简单的方式），但是出现了TimeLimit，没办法，只得想想算法。



