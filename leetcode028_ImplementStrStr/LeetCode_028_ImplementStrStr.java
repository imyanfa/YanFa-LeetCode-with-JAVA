import org.junit.Test;

public class LeetCode_028_ImplementStrStr
{
    /*
    //注释中为KMP实现，由于java中字符串的特殊性，KMP效率并没有下面的暴力破解高
    public int strStr(String haystack, String needle)
    {
        if(needle.length() == 0)
            return 0;
        char[] T = haystack.toCharArray();
        char[] P = needle.toCharArray();
        return kmp(T, P);
    }

    private int kmp(char[] T, char[] P)
    {
        int n = T.length;
        int m = P.length;
        int[] next = getNext(P);
        int q = -1;
        for(int i = 0; i < n; i++)
        {
            while(q >= 0 && P[q+1] != T[i])
                q = next[q];
            if(P[q+1] == T[i])
                q++;
            if(q == m-1)
                return i-m+1;
        }
        return -1;
    }

    private int[] getNext(char[] P)
    {
        int[] next = new int[P.length];
        int k=-1;
        next[0] = -1;
        for(int q = 1; q < P.length;q++)
        {
            while(k >= 0 && P[k+1] != P[q])
                k = next[k];
            if(P[k+1] == P[q])
                k++;
            next[q] = k;
        }
        return next;
    }
    */

    public int strStr(String haystack, String needle)
    {
        if(needle.length() == 0)
            return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            if(needle.equals(haystack.substring(i, i + needle.length())))
                return i;
        }
        return -1;
    }

    @Test
    public void testStrStr()
    {
        String s1 = "vvaaa";
        String s2 = "a";
        System.out.println(strStr(s1, s2));
    }
}