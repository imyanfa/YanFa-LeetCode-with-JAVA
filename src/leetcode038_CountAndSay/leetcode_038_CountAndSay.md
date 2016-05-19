# *题目*
The count-and-say sequence is the sequence of integers beginning as follows:  
1, 11, 21, 1211, 111221, ...  
1 is read off as "one 1" or 11.  
11 is read off as "two 1s" or 21.  
21 is read off as "one 2, then one 1" or 1211.  
Given an integer n, generate the nth sequence.  
Note: The sequence of integers will be represented as a string.   
## 思路：
这题挻有意思的，关键要搞懂题目意思，它的意思是说让统计相同的数，然后用这个统计的个数和原来的一个数一起替换原来的那一串相同的数。举个例子：如果有连续5个1，则替换为51，4个2则替换为42。  
比如：1211替换过程如下：有1个1，则1换成11；有一个2，则把2换成12；接下来有连续2个1，则把这两个1换成21；所以最终的结果是：1211 -->  111211  
递归求解，然后统计重复字符。
## 代码：
```java
public String countAndSay(int n)
{
    if(n==1) return String.valueOf(1);
    String s = countAndSay(n-1);
    char[] chars = s.toCharArray();
    StringBuilder res = new StringBuilder();
    int i=0;
    while(i<chars.length){
        int count = 1;
        char lastChar = chars[i];
        for(i = i+1; i < chars.length && chars[i] == lastChar; i++)
            count++;
        res.append(count).append(lastChar);
    }
    return res.toString();
}
```
## 结果细节（图）：