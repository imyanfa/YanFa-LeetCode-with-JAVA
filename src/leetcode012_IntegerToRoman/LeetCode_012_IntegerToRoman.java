import org.junit.Test;

public class LeetCode_012_IntegerToRoman
{
    private char getChar(int key)
    {
        char res = '\0';
        switch(key)
        {
            case 1:
                res = 'I';
                break;
            case 5:
                res = 'V';
                break;
            case 10:
                res = 'X';
                break;
            case 50:
                res = 'L';
                break;
            case 100:
                res = 'C';
                break;
            case 500:
                res = 'D';
                break;
            case 1000:
                res = 'M';
                break;
        }
        return res;
    }

    public String intToRoman(int num)
    {
        StringBuilder roman = new StringBuilder();

        int flag = 1000;
        while(num < flag)
            flag /= 10;
        while(flag > 0)
        {
            int n = num / flag;

        if(n == 9 || n == 4)
            {
                roman.append(getChar(flag)).append(getChar((n + 1) * flag));
                n = 0;
            } else if(n / 5 > 0)
            {
                roman.append(getChar(5 * flag));
                n -= 5;
            }
            for(int i = n; i > 0; i--)
            {
                roman.append(getChar(flag));
            }

            num %= flag;
            flag /= 10;
        }

        return roman.toString();
    }

    @Test
    public void testIntRoman()
    {
        System.out.println(intToRoman(3999));
    }
}

