# *题目* 5. Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
#### 思路：
我总结出来的回文有两种形式：ABCBA和ABCCBA，即回文串的长度分为奇数的偶数。其中奇数形式最容易判断：利用一个指针i（整型变量）从第一个字符开始向后走，再定义一个整型变量j从1开始递增。当i大于等于j且j小于串的长度且i-j和i+j所指客随字符相同时就一直循环，像这样：`while(i >= j && i + j < length && s_char[i - j] == s_char[i + j]) j++;`。退出循环时就找到了一个回文串，记算该回文串的长度（根据j就能计算），与上一次记录的相比较，如大于则记录长度和该回文串的开始位置。直到i循环到最后一个字符则找到最长回文串。但是这种算法对ABCCBA雍容这种形式的串就无能为力了，所以可以想办法把两种形式统一一下。于是可以在原字符串的每个字符之间插入一个特殊字符如‘-’，并有原串的两端也插入，于是得出的串为这种形式：-A-B-C-B-A-和-A-B-C-C-B-A-，这样所有的回文子串都成了奇数的长度，按照以上的算法便能求解。

#### 提交代码：
```java
    public String longestPalindrome(String s)
    {
        int length = 2*s.length()+1;
        char[] s_char = new char[length];
        for(int i = 0, j = 0; j < length-1; j++)
        {
            if(j%2==0)
                s_char[j]='-';
            else
                s_char[j]=s.charAt(i++);
        }
        s_char[length-1]='-';
        int i = 0,j = 1;

        int start = 0, res_len = 1;
        while(i < length)
        {
            while(i >= j && i + j < length && s_char[i - j] == s_char[i + j])
                j++;
            j--;
            int tmp = 2*j+1;

            if(tmp > res_len)
            {
                start = i - j;
                res_len = tmp;
            }
            i++;
            j = 1;
        }

        char[] result = new char[(res_len-1)/2];
        for(i = 0; i < result.length; i++)
        {
            result[i] = s_char[++start];
            start++;
        }
        return new String(result);
    }
```
#### 提交结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode005_longestPalindrome/img/1.png)

#### 总结：
从细节图看出效率并不是很高，但也在能接受的范围内。以后有想法了再修改。
