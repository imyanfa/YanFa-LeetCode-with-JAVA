import org.junit.Test;

public class LeetCode_008_atoi
{
    public int myAtoi(String str)
    {
        str = str.trim(); //去除空白字符

        if(str.isEmpty()) //若长度为0则返回0
            return 0;

        char tmp = str.charAt(0);
        if(tmp != '-' && tmp != '+' && (tmp <48 || tmp > 57) )
            return 0;//首字符若不是数字或者正负号的时候也返回0

        char[] str_char = str.toCharArray();
        int i = 0;
        int sign = 1; //判断符号
        if(str_char[0] == '-')
        {
            sign = -1;
            i++;
        }else if(str_char[0] == '+')
            i++;

        long res = 0;
        for(; i < str_char.length; i++)
        {
            //若下一个为其他非数字字符跳出循环，第一个正负号无需考虑，前面已经排除
            //若转换中途超出范围则跳出循环
            if(str_char[i] < 48 || str_char[i]> 57 || res > Integer.MAX_VALUE)
                break;

            res = res * 10 + (str_char[i]-48);
        }

        res *= sign;
        if(res > Integer.MAX_VALUE)
            res = Integer.MAX_VALUE;
        else if(res < Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;

        return (int)res;
    }

    @Test
    public void testMyAtoi()
    {
        System.out.println(myAtoi("-21474836478"));
    }
}
