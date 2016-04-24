# *题目*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.   
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
#### 思路：
这道题要做出来可以说非常简单，数据结构课程在讲栈的这节时有例题就是这个。我开始想用JAVA集合框架中的类来做，但一思考，对于本题来说集合框架太大材小用了。如果自己实现栈也可以，但还是不够高效。于是，我用了一个和字符串等长的数组来实现栈的结构。只需要一个指向数组末端的指针即可。具体实现看代码。
#### 代码：
```java
public boolean isValid(String s)
{
    if(s == null || s.length() == 0)
        return true;
    char[] sChars = s.toCharArray();
    char[] stack = new char[sChars.length];
    int top = 0;
    boolean res = true;
    for(char c : sChars)
    {
        if(c == '(' || c == '{' || c == '[')
        {
            stack[top++] = c;
            continue;
        }
        char tmp = top!=0? stack[--top]:'\0';
        if(c == ')')
        {
            if(tmp != '(')
            {
                res = false;
                break;
            }
        } else if(c == ']')
        {
            if(tmp != '[')
            {
                res = false;
                break;
            }
        } else if(c == '}')
        {
            if(tmp != '{')
            {
                res = false;
                break;
            }
        }
    }
    return top == 0 && res;
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode020_ValidParentheses/img/1.png)