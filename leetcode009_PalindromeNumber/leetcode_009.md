# *题目*
**9. Palindrome Number**  
Determine whether an integer is a palindrome. Do this without extra space.  
**Some hints:**  
Could negative integers be palindromes? (ie, -1)  
If you are thinking of converting the integer to string, note the restriction of using extra space.  
You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?  
There is a more generic way of solving this problem.
#### 提交思路：
一位数直接返回true，若为负数或者不为0的整10倍数返回false。剩下的就要靠算法排除了。我的算法思路如下：用个变量保存x的一半(位数)，比如x=123321，则half为123（从后向前数一半的位数）；当x=12321时，half则为123；所以只要在结束时判断half和x的即可得出结论。PS. 排除整十数很重要！
#### 提交代码：
```java
public boolean isPalindrome(int x){
    if(x >= 0 && x < 10)
        return true;
    if(x < 0 || x % 10 == 0)
        return false;
    int half = 0;
    do {
        half = half * 10 + x % 10;
    } while((x /= 10) > half);
    return half > x ? half / 10 == x : half == x;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode009_PalindromeNumber/img/1.png)
