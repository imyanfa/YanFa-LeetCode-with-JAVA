import org.junit.Test;

import java.util.*;

public class LeetCode_022_GenerateParentheses
{
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

    @Test
    public void testGenerateParenthesis()
    {
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
        System.out.println(list.size());
    }
}