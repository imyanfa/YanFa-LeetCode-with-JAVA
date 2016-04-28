import org.junit.Test;

/**
 * @author yanfa
 * @version 1.0 2016-04-27
 */
public class LeetCode_032_LongestValidParentheses
{
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

    @Test
    public void testLVP()
    {
        System.out.println(longestValidParentheses("()()"));
    }
}