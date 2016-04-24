import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_017_LCoaPN
{
    private List<String> out = new ArrayList<>();
    private List<String> in = new ArrayList<>();
    private String[] resources = {"", "", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits)
    {
        if(digits == null || digits.length() == 0 || digits.contains("1") || digits.contains("0"))
            return out;
        char[] c_digits = digits.toCharArray();
        for(char c_digit : c_digits) in.add(resources[c_digit - '0']);
        getString("", 0);
        return out;
    }

    private void getString(String builder, int index)
    {
        char[] chars = in.get(index).toCharArray();
        if(index == in.size() - 1)
            for(char c : chars)
                out.add(builder + c);
        else
            for(char aChar : chars)
                getString(builder + aChar, index + 1);
    }

    @Test
    public void testLetterCombinations()
    {
        String s = "23";
        letterCombinations(s);
        out.forEach(System.out::println);
    }
}
