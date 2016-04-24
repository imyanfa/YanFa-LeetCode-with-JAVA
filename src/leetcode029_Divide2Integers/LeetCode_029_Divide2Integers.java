import org.junit.Test;

public class LeetCode_029_Divide2Integers
{
    public int divide(int dividend, int divisor)
    {
        if(divisor == 1) return dividend;//除数为1的情况。。。
        if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;//除数为-1时。。。
        boolean sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);//记录返回值的正负号
        dividend = dividend > 0 ? -dividend : dividend;//被除数取负数
        divisor = divisor > 0 ? -divisor : divisor;//除数取负数
        int res = div(dividend, divisor);//开始递归
        return sign ? res : -res;
    }

    private int div(int dividend, int divisor)
    {
        if(dividend > divisor) return 0;
        if(dividend == divisor) return -1;
        int res = -1, tmp = divisor;
        while(dividend - tmp <= tmp)
        {
            tmp <<= 1;//相当于tmp*=2;
            res <<= 1;//相当于res*=2;
        }
        return div(dividend - tmp, divisor) + res;
    }

    @Test
    public void testDivide()
    {
        System.out.println(divide(-2147483648, -1));
    }
}
