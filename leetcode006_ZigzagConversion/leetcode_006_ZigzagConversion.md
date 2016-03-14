# *题目*
**6. ZigZag Conversion**  
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
```
P       A       H       N
A   P   L   S   I   I   G
Y       I       R
```
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
 `string convert(string text, int nRows);`
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

#### 思路
这题没有难度，关键在于弄懂题意然后找到字母变换的规律，题目意思是把字母变换成锯齿状，形如：`|/|/|/|` 。第一行和最后一行的比较好找`2 * numRows - 2`，中间的就需要好好思考一下了。首先，还是有`2 * numRows - 2`这一样的的字母存在，只是中间比这多了一部分如题目中的P,S...，这里的规律是：在前一个字母的位置上`+(2 * numRows - 2) - 2 * i`。

#### 提交代码：
```java
public String convert(String s, int numRows)
{
    int length = s.length();
    if(length <= 2 || numRows <= 1)
        return s;
 
    char[] s_char = s.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    int flag = 2 * numRows - 2;
    for(int i = 0; i < numRows; i++)
    {
        for(int j = i; j < length; j += flag)
        {
            stringBuilder.append(s_char[j]);
            if(i > 0 && i < numRows - 1)
            {
                int tmp = j + flag -  2*i;
                if(tmp < length) stringBuilder.append(s_char[tmp]);
            }
        }
    }
    return stringBuilder.toString();
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode006_ZigzagConversion/img/1.png)
#### 提交总结：
1. 在JAVA中要操作String中的单个字符时，先把它变成字符数组。
2. 在JAVA中要拼接一个String时，用StringBuilder或字符数组效率较高（千万不要用string+string这种形式！！！）

