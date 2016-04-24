# *题目*
Divide two integers without using multiplication, division and mod operator.   

If it is overflow, return MAX_INT.

## 思路：
利用移位操作符求解，但是对于移位运算我并不拿手。所以我参考了一个[C#的解](https://leetcode.com/discuss/97971/easy-divide-and-conquer-solution)，用递归解的。  
在递归之前先要把数据进行处理一下：    
1. 除数为1时，直接返回被除数。  
2. 除数为-1时，有两种情况：    
 - 若被除数为`Integer.MIN_VALUE`时，因为`Integer.MIN_VALUE`除-1会溢出，所以返回`Integer.MAX_VALUE`      
 - 否则返回被除数的相反数        
3. 要记下返回值的正负号，被除数与除数符号相反则为负，否则为正。   
4. 将被除数与除数都取负数，目的是方便计算，排除以第2点后，负数运算不会溢出。   
5. 开始递归。 

PS: 除数为0的情况不用考虑，用例中没有出现这种情况。   
递归过程：  
- **特别注意，这里为两个负数运算**   
- 递归结束条件：被除数比除数大时(因为为负数运算)，返回0；相等时返回1。  
- 在递归过程中，依次用被除数去减除数的$2^i$倍，直到$dividend - (divisor)^i <= (divisor)^i$为止。这个过程相当于找一个小于商的数，而递归过程就是在不断的使这个数接近商，最终得到结果的过程。 
- 用了两次左移运算，左移相当于乘2   

## 代码：
```java
public int divide(int dividend, int divisor)

{

    if(divisor == 1) return dividend;//除数为1的情况。。。

    if(divisor == -1) return dividend == Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;//除数为-1时。。。

    boolean sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);//记录返回值的正负号

    dividend = dividend > 0 ? -dividend : dividend;//被除数取负数

    divisor = divisor > 0 ? -divisor : divisor;//除数取负数

    int res = div(dividend, divisor);开始递归

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

```
## 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode029_Divide2Integers/img/1.png)
