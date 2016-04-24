# *题目*
**12. Integer to Roman**   
Given an integer, convert it to a roman numeral.  

Input is guaranteed to be within the range from 1 to 3999.  

#### 思路：
本想用HashMap来存储数字与字母的对应关系，但是考虑到只是存放映射关系的话用Map太庞大了，于是自己写了一个方法getChar来存放映射关系。然后就从高位依次向下计算找到对应的字母即可，每位如果是数字4和9的话就要仔细考虑。PS: 罗马数字与阿拉伯数字转换：[点击这里](http://iask.sina.com.cn/b/2801884.html)
#### 代码：
```java
private char getChar(int key)

{

    char res = '\0';

    switch(key)

    {

        case 1:

            res = 'I';

            break;

        case 5:

            res = 'V';

            break;

        case 10:

            res = 'X';

            break;

        case 50:

            res = 'L';

            break;

        case 100:

            res = 'C';

            break;

        case 500:

            res = 'D';

            break;

        case 1000:

            res = 'M';

            break;

    }

    return res;

}

public String intToRoman(int num)

{

    StringBuilder roman = new StringBuilder();

    int flag = 1000;

    while(num < flag)

        flag /= 10;

    while(flag > 0)

    {

        int n = num / flag;

        if(n == 9 || n == 4)

        {

            roman.append(getChar(flag)).append(getChar((n + 1) * flag));

            n = 0;

        } else if(n / 5 > 0)

        {

            roman.append(getChar(5 * flag));

            n -= 5;

        }

        for(int i = n; i > 0; i--)

            roman.append(getChar(flag));

        num %= flag;

        flag /= 10;

    }

    return roman.toString();

}

```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode012_IntegerToRoman/img/1.png)
