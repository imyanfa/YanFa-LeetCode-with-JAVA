# *题目*
**14. Longest Common Prefix**   
Write a function to find the longest common prefix string amongst an array of strings.
#### 思路：
我的思路是利用java的不规则二维数组来存储给定的字符串数组，二维数组的每一行为原字符串数组的一个字符串，像下面这样：
```
//String数组：
["hello","hell","hi","helloword"] 
//不规则的二维字符数组：
h e l l o
h e l l
h i
h e l l o w o r l d
```
- 在构造这个二维数组的时候要请注意检查空的情况，并且记录下最短字符长度。    
- 然后按列遍历这个二维数组，直到某一个字符与其他不相等就构造一个字符串并返回。  
- 如果没有在遍历过程中返回的话，也就是说程序执行到了最后，那么就说明给定的字符串中有一个就是完整的相同前缀，现在只需随便在二维数组中找一行构造字符串，当然找第一行最方便，从0开始，以开始记下的最短长度为长度new串。    
PS: 最开始要排除一些特殊情况：给定的字符串数组为空或者其中某一个为空等等。  

#### 代码：
```java
public String longestCommonPrefix(String[] strs)
{
    if(strs.length == 0)
        return "";
    int shortestLength = Integer.MAX_VALUE;
 
    //创建不规则二维数组
    char[][] chars = new char[strs.length][];
    for(int i = 0; i < chars.length; i++)
    {
        if(strs[i] == null || strs[i].length() == 0)
            return "";
        chars[i] = strs[i].toCharArray();
        if(shortestLength > chars[i].length)
            shortestLength = chars[i].length;
    }
 
    //开始循环，找最长前缀
    //循环规则是按列循环
    int i, j;
    for(j = 0; j < shortestLength; j++)
    {
        int tmp_char = chars[0][j];
        for(i = 1; i < chars.length; i++)
        {
            if(tmp_char != chars[i][j])
                return new String(chars[0],0,j);
        }
    }
    return new String(chars[0],0,shortestLength);
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode014_LongestCommonPrefix/img/1.png)
