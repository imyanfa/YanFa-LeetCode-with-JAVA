import org.junit.Test;

public class LeetCode_009_PalindromeNumber
{
    public boolean isPalindrome(int x)
    {
        if(x >= 0 && x < 10)
            return true;
        if(x < 0 || x % 10 == 0)
            return false;
        int half = 0;
        do {
            half = half * 10 + x % 10;
        } while((x /= 10) > half);
        return half > x ? half / 10 == x : half == x;
    }


    @Test
    public void testIsPalindrome()
    {
        System.out.println(isPalindrome(12321) ? "true" : "false");
    }
}
