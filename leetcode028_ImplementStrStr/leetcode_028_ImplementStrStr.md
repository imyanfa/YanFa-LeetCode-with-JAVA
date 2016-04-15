# *题目*
**28. Implement strStr()**  
Implement strStr().  
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.  
## 思路：
开始我想用KMP算法求解，但是时间大概要7~8ms，这效率太低了。由于JAVA的String不同于C中的字符数组，所以用KMP比较还不如暴力破解来得快，也可能是我能力有限，没有能力针对JAVA对KMP算法进行优化。
## 代码：
```java
public int strStr(String haystack, String needle)
{
    if(needle.length() == 0)
        return 0;
    for(int i = 0; i < haystack.length() - needle.length() + 1; i++)
    {
        if(needle.equals(haystack.substring(i,i+needle.length())))
            return i;
    }
    return -1;
}
```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode028_ImplementStrStr/img/1.png)
## 附：JAVA的KMP实现
```java
public int strStr(String haystack, String needle)
{
    if(needle.length() == 0)
        return 0;
    char[] T = haystack.toCharArray();
    char[] P = needle.toCharArray();
    return kmp(T, P);
}

private int kmp(char[] T, char[] P)
{
    int n = T.length;
    int m = P.length;
    int[] next = getNext(P);
    int q = -1;
    for(int i = 0; i < n; i++)
    {
        while(q >= 0 && P[q+1] != T[i])
            q = next[q];
        if(P[q+1] == T[i])
            q++;
        if(q == m-1)
            return i-m+1;
    }
    return -1;
}

private int[] getNext(char[] P)
{
    int[] next = new int[P.length];
    int k=-1;
    next[0] = -1;
    for(int q = 1; q < P.length;q++)
    {
        while(k >= 0 && P[k+1] != P[q])
            k = next[k];
        if(P[k+1] == P[q])
            k++;
        next[q] = k;
    }
    return next;
}
```
