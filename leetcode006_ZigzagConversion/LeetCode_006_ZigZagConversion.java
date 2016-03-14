import org.junit.Test;

public class LeetCode_006_ZigZagConversion
{
    public String convert(String s, int numRows)
    {
        int length = s.length();
        if(length <= 2 || numRows <= 1)
            return s;

        char[] s_char = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++)
        {
            for(int j = i; j < length; j += flag)
            {
                stringBuilder.append(s_char[j]);
                if(i > 0 && i < numRows - 1)
                {
                    int tmp = j + flag - 2 * i;
                    if(tmp < length) stringBuilder.append(s_char[tmp]);
                }
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void testConvert()
    {
        String s = convert("PAYPALISHIRING",3);
        if(s.equals("PAHNAPLSIIGYIR"))
            System.out.println("true");
        else
            System.out.println("false");
        System.out.println(s);
    }
}
