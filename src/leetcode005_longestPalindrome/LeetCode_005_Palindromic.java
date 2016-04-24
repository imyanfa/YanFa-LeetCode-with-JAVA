import org.junit.Test;

public class LeetCode_005_Palindromic
{
    public String longestPalindrome(String s)
    {
        int length = 2*s.length()+1;
        char[] s_char = new char[length];
        for(int i = 0, j = 0; j < length-1; j++)
        {
            if(j%2==0)
                s_char[j]='-';
            else
                s_char[j]=s.charAt(i++);
        }
        s_char[length-1]='-';
        System.out.println(new String(s_char));
        int i = 0,j = 1;

        int start = 0, res_len = 1;
        while(i < length)
        {
            while(i >= j && i + j < length && s_char[i - j] == s_char[i + j])
                j++;
            j--;
            int tmp = 2*j+1;

            if(tmp > res_len)
            {
                start = i - j;
                res_len = tmp;
            }
            i++;
            j = 1;
        }

        char[] result = new char[(res_len-1)/2];
        for(i = 0; i < result.length; i++)
        {
            result[i] = s_char[++start];
            start++;
        }
        return new String(result);
    }


    @Test
    public void testLongestPalindrome()
    {
        System.out.println(longestPalindrome("abcbabadasfdsatqeredfsda"));
    }
}
