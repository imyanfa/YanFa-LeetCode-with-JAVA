# *题目*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

# *第一次提交*（失败）
#### 总结
我想利用LinkedHashMap的特性（保持原来的顺序存储不重复的元素）来解决问题，但是这样的话会有各种特殊情况，比如在我下面帖出的代码中输入“tdmmgekoat”，正确结果应为7，但是输出却为6，原因为Map在插入最后一个元素t的时候会覆盖掉第一个t，从而导致数据出现错误。但是利用HashMap确实能解决此题（HashSet也行）[点击这是查看](https://leetcode.com/discuss/88989/simple-java-solution-using-hashmap)。
#### 第一次提交代码：
```java
    //下面是错误的代码，看看就好，不要参考！！！
    public int lengthOfLongestSubstring(String s)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int length = 0;
        int tmp;
        int lose = 0;
        int tmp1 = 0;
        for(int i = 0, j = 0; i < s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                tmp1 = map.put(s.charAt(i),i);
            else
                map.put(s.charAt(i),i);
            tmp = i-j+1;
            if(tmp1 > j && map.size()-lose != tmp)
            {
                if(length < tmp-1)
                {
                    length = tmp-1;
                }
                j = tmp1+1;
                lose = j-1;
            }else if(tmp > length)
                length = tmp;
        }
 
        return length;
    }
```

# *第二次提交*
#### 第二次提交代码：
```java
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
```
#### 第二次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode003_MaxSubString/img/1.png)
#### 第二次提交总结：
改变思路后，果然顺利了许多。第二次的思路：利用一个数组tmp来存储每个字符出现的位置，而在这个数组存储时以字符的ASCII作为下标。若字符是首次出现，则在tmp数组对应的位置记录下它原来所在的位置，若不是第一次出现，则先取出原来的数据再覆盖。注意：先把String转成字符数组再操作(利用String的toCharArray()方法)，效率会高很多。
