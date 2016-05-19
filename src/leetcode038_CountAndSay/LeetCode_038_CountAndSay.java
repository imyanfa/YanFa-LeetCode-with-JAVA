import org.junit.Test;

/**
 * @author yanfa
 * @version 1.0 2016-05-19
 */
public class LeetCode_038_CountAndSay
{
    public String countAndSay(int n)
    {
        if(n==1) return String.valueOf(1);
        String s = countAndSay(n-1);
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int i=0;
        while(i<chars.length){
            int count = 1;
            char lastChar = chars[i];
            for(i = i+1; i < chars.length && chars[i] == lastChar; i++)
                count++;
            res.append(count).append(lastChar);
        }
        return res.toString();
    }

    @Test
    public void testCountAndSay()
    {
        System.out.println(countAndSay(1));
    }
}