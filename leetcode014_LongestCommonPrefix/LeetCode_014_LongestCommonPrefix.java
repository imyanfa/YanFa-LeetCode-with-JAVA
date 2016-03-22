import org.junit.Test;

public class LeetCode_014_LongestCommonPrefix
{
    public String longestCommonPrefix(String[] strs)
    {
        if(strs.length == 0)
            return "";
        int shortestLength = Integer.MAX_VALUE;

        //创建不规则二维数组
        char[][] chars = new char[strs.length][];
        for(int i = 0; i < chars.length; i++)
        {
            if(strs[i] == null || strs[i].length() == 0)
                return "";
            chars[i] = strs[i].toCharArray();
            if(shortestLength > chars[i].length)
                shortestLength = chars[i].length;
        }

        //开始循环，找最长前缀
        //循环规则是按列循环
        int i, j;
        for(j = 0; j < shortestLength; j++)
        {
            int tmp_char = chars[0][j];
            for(i = 1; i < chars.length; i++)
            {
                if(tmp_char != chars[i][j])
                    return new String(chars[0],0,j);
            }
        }

        return new String(chars[0],0,shortestLength);
    }

    @Test
    public void testLongestCommonPrefix()
    {
        String[] strings = new String[]{"woaa", "woq", "wos"};
        System.out.println(longestCommonPrefix(strings));
    }
}
