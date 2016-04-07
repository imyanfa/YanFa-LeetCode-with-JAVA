# *题目*
**22. Generate Parentheses**  
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.  
For example, given n = 3, a solution set is:  
```
"((()))", "(()())", "(())()", "()(())", "()()()"
```
#### 思路：
利用递归求解，递归这玩意不好解释，建议调试几次，追踪代码执行过程，用机器的方式去思考。
#### 代码：
```java
private List<String> list;

public List<String> generateParenthesis(int n)
{
    String s = "";
    list = new ArrayList<>();
    generate(n, n, s);
    return list;
}

void generate(int left, int right, String s)
{
    if(left != 0)
    {
        generate(left - 1, right, s + "(");
        if(left != right)
        {
            generate(left, right - 1, s + ")");
        }
    } else
    {
        if(right != 0)
        {
            int tmp = right;
            StringBuilder builder = new StringBuilder(s);
            while(tmp-- > 0)
                builder.append(')');
            list.add(builder.toString());
        }
    }
}
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode022_GenerateParentheses/img/1.png)