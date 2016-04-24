# *题目*
**13. Roman to Integer**  
Given a roman numeral, convert it to an integer.  
 Input is guaranteed to be within the range from 1 to 3999.
#### 思路：
这道题相比Integer To Roman更简单，直接从罗马数字的最低位开始转换（一个字母一个字母的转换），每次要记录下前一次的数，若此次的数比前一次的小，则在结果减去本次的数，否则加上本次的数。
#### 代码：
```java
private int getNumber(char key)
{
    int res = 0;
    switch(key)
    {
        case 'I':
            res = 1;
            break;
        case 'V':
            res = 5;
            break;
        case 'X':
            res = 10;
            break;
        case 'L':
            res = 50;
            break;
        case 'C':
            res = 100;
            break;
        case 'D':
            res = 500;
            break;
        case 'M':
            res = 1000;
            break;
    }
    return res;
}
public int romanToInt(String s)
{
    char[] s_char = s.toCharArray();
    int i = s_char.length-1;
    int lastNum = 0;
    int res = 0;
    while(i >= 0)
    {
        int tmp = getNumber(s_char[i--]);
        if(tmp < lastNum)
            res -= tmp;
        else
            res += tmp;
        lastNum = tmp;
    }
 
    return res;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode013_RomanToInteger/img/1.png)
