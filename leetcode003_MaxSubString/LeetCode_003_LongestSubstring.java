import org.junit.Test;


public class LeetCode_003_LongestSubstring
{
//    public int lengthOfLongestSubstring(String s)
//    {
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        int length = 0;
//        int tmp;
//        int lose = 0;
//        int tmp1 = 0;
//        for(int i = 0, j = 0; i < s.length();i++)
//        {
//            if(map.containsKey(s.charAt(i)))
//                tmp1 = map.put(s.charAt(i),i);
//            else
//                map.put(s.charAt(i),i);
//            tmp = i-j+1;
//            if(tmp1 > j && map.size()-lose != tmp)
//            {
//                if(length < tmp-1)
//                {
//                    length = tmp-1;
//                }
//                j = tmp1+1;
//                lose = j-1;
//            }else if(tmp > length)
//                length = tmp;
//        }
//
//        return length;
//    }

    public int lengthOfLongestSubstring(String s)
    {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        int length = s.length();
        char[] sToChars = s.toCharArray();
        int[] tmp = new int[128];
        int i = 0, j =0;

        int maxSubLength = 0;
        int index;
        while(i < length)
        {
            if(tmp[sToChars[i]] == 0)
            {
                tmp[sToChars[i]] = ++i;
                if(i - j > maxSubLength)
                    maxSubLength = i-j;
            }else
            {
                index = tmp[sToChars[i]];
                tmp[sToChars[i]]=0;
                if(j < index)
                    j = index;
            }
        }

        return maxSubLength;
    }

    @Test
    public void testLengthOfLongestSubstring()
    {
        int i = lengthOfLongestSubstring("aa");
        System.out.println(i);
    }
}
