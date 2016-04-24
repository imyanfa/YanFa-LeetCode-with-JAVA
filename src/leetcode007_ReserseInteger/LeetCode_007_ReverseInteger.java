import org.junit.Test;

import javax.sound.midi.Soundbank;

public class LeetCode_007_ReverseInteger
{
//    public int reverse(int x)
//    {
//        boolean flag = true;
//        if(x == Integer.MIN_VALUE)
//            return 0;
//        if(x < -9)
//        {
//            flag = false;
//            x = Math.abs(x);
//        }
//        else if(x < 10)
//            return x;
//
//        while(x%10==0)
//            x /= 10;
//
//        String s = String.valueOf(x);
//        char[] s_char = s.toCharArray();
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = s_char.length-1; i>=0; i--)
//        {
//            stringBuilder.append(s_char[i]);
//        }
//
//        long tmp = Long.parseLong(stringBuilder.toString());
//        if(tmp > Integer.MAX_VALUE)
//            x = 0;
//        else
//            x = (int)tmp;
//
//        return flag?x:0-x;
//    }

    public int reverse(int x)
    {
        if(x > -10 && x < 10)  //一位数直接返回
            return x;
        if(x == Integer.MIN_VALUE) //特殊，这个值求绝对值还是它自身，原因为它求绝对值会发生正溢出
            return 0;
        int flag = x > 0 ? 1 : -1; //记录下符号

        x = Math.abs(x);

        long result = 0;

        while(x != 0)
        {
            int tmp = x % 10;
            result = result * 10 + tmp;  //反转
            x /= 10;
        }
        return result > Integer.MAX_VALUE ? 0 : flag * (int) result;
    }

    @Test
    public void testReverse()
    {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
