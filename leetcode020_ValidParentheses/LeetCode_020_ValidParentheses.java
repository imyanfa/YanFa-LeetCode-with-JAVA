import org.junit.Test;

public class LeetCode_020_ValidParentheses
{
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

    @Test
    public void testIsValid()
    {
        String s = "]";
        System.out.println(isValid(s));
    }
}
