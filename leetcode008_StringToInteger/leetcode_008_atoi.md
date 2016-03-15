# *题目*
**8. String to Integer (atoi)**  
Implement atoi to convert a string to an integer.  
**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.  
**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.  
**Requirements for atoi:**
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
#### 提交思路：
这道题还是很简单的，把各种特殊情况排除，利用ASCII码表很容易求解。

####  提交代码：
```java
public int myAtoi(String str)
{
    str = str.trim(); //去除空白字符

    if(str.isEmpty()) //若长度为0则返回0
        return 0;

    char tmp = str.charAt(0);
    if(tmp != '-' && tmp != '+' && (tmp <48 || tmp > 57) )
        return 0;//首字符若不是数字或者正负号的时候也返回0

    char[] str_char = str.toCharArray();
    int i = 0;
    int sign = 1; //判断符号
    if(str_char[0] == '-')
    {
        sign = -1;
        i++;
    }else if(str_char[0] == '+')
        i++;

    long res = 0;
    for(; i < str_char.length; i++)
    {
        //若下一个为其他非数字字符跳出循环，第一个正负号无需考虑，前面已经排除
        //若转换中途超出范围则跳出循环
        if(str_char[i] < 48 || str_char[i]> 57 || res > Integer.MAX_VALUE)
            break;

        res = res * 10 + (str_char[i]-48);
    }

    res *= sign;
    if(res > Integer.MAX_VALUE)
        res = Integer.MAX_VALUE;
    else if(res < Integer.MIN_VALUE)
        res = Integer.MIN_VALUE;

    return (int)res;
}
```
####  结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode008_StringToInteger/img/1.png)
