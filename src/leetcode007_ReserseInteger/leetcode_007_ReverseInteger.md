# *题目*
**7. Reverse Integer**  
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

# *第一次提交*
#### 第一次提交思路：
先除一些特殊情况，比如-9到9可以直接返回， Integer.MIN_VALUE这个数很特殊，这个值求绝对值还是它自身，原因为它求绝对值会发生正溢出。然后排除末位的0，然后就利用字符串进行反转，事实证明，这种做法把简单的问题复杂化了。
#### 第一次提交代码：
```java
public int reverse(int x)
{
    boolean flag = true;
    if(x == Integer.MIN_VALUE)
        return 0;
    if(x < -9)
    {
        flag = false;
        x = Math.abs(x);
    }
    else if(x < 10)
        return x;

    while(x%10==0)
        x /= 10;

    String s = String.valueOf(x);
    char[] s_char = s.toCharArray();

    StringBuilder stringBuilder = new StringBuilder();
    for(int i = s_char.length-1; i>=0; i--)
    {
        stringBuilder.append(s_char[i]);
    }

    long tmp = Long.parseLong(stringBuilder.toString());
    if(tmp > Integer.MAX_VALUE)
        x = 0;
    else
        x = (int)tmp;

    return flag?x:0-x;
}
```
#### 第一次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode007_ReserseInteger/img/1.png)

# *第二次提交*
#### 第二次提交思路：
开始还是把特殊情况都排除掉。然后利用数学规律进行反转，具体如代码注释。
#### 第二次提交代码：
```java
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
```
#### 第二次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode007_ReserseInteger/img/2.png)
#### 总结
对于纯数字的操作，看来还是用数字来效率更高。

