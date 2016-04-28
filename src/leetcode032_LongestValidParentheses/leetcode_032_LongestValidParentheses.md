# *题目*
Given a string containing just the characters` '('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.    
For `"(()"`, the longest valid parentheses substring is `"()"`, which has length = 2.    
Another example is `")()())"`, where the longest valid parentheses substring is `"()()"`, which has length = 4.    

## 思路：
利用栈和标记数组来做。    
1. 初始化：  
 - 标记数组flags，类型为boolean，长度为输入字符串的长度，默认全为false，开始全未配对；    
 - 模拟栈的数组stack，类型为int，长度为输入数组的长度。    
2. 遍历输入字符串：    
 - 如当前字符为'('，则在stack中记录其下标    
 - 若当前字符为')'：判断stack是否为空，不为空则说明前面有与之配对的左括号   ，则将这两个括号所对应的flags全标为true，表示已配对；否则什么都不做，继续遍历。  
3. 当遍历结束后，标记数组中已配对的括号位置都被设为了true。比如：假设输入字符串为`")())()()`",则flags为`{false,true,true,false,true,true,true,true}`;    
4. 从flags中找出连续为true的最大长度，即为所求最大配对长度。  
## 代码：
```java
public int longestValidParentheses(String s)
{
    int length = s.length();
    boolean[] flags = new boolean[length];  //用来标记是否配对
    int[] stack = new int[length]; //模拟栈，用来记录未配对的括号的位置
    int top = 0;    //栈顶指针
    for(int i = 0; i < length; i++)
    {
        if(s.charAt(i) == ')')
        {
            //如果当前为')'话，且栈不为空，则这个右括号之前有与之配对的左括号
            //将这两个括号对应的标志位都设为true，表明已配对，同时栈顶指针减1
            if(top > 0)
                flags[i] = flags[stack[--top]] = true;
        } else
        {
            //如果当前为'('，则在栈中记录其位置
            stack[top++] = i;
        }
    }

    //循环结束后，标记数组中已配对的括号位置都被设为了true
    //比如：假设输入字符串为")())()()",则flags为{false,true,true,false,true,true,true,true};
    //下面只需从flags中找到连续为true的最大长度即可，此长度就是最大配对长度
    int res, tmp;
    res = tmp = 0;
    int i;
    for(i = 0; i < length; i++)
    {
        if(flags[i])
            tmp++;
        else
        {
            res = tmp > res ? tmp : res;
            tmp = 0;
        }
    }
    return (res < tmp) ? tmp : res;
}

```
## 结果细节（图）：

