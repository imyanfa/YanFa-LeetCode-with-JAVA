import org.junit.Test;

public class LeetCode_013_RomanToInteger
{
    private int getNumber(char key)
    {
        int res = 0;
        switch(key)
        {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
        }
        return res;
    }
    public int romanToInt(String s)
    {
        char[] s_char = s.toCharArray();
        int i = s_char.length-1;
        int lastNum = 0;
        int res = 0;
        while(i >= 0)
        {
            int tmp = getNumber(s_char[i--]);
            if(tmp < lastNum)
                res -= tmp;
            else
                res += tmp;
            lastNum = tmp;
        }

        return res;
    }

    @Test
    public void testRomanToInt()
    {
        System.out.println(romanToInt("MMMCDXCVII"));
    }
}
