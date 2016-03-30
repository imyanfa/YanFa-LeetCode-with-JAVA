# *题目*
**17. Letter Combinations of a Phone Number**   
Given a digit string, return all possible letter combinations that the number could represent.   
A mapping of digit to letters (just like on the telephone buttons) is given below.  
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode017_LetterCombinationofaPhoneNumber/img/2.png)

```
Input:Digit string "23" 
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```
#### 思路：
利用递归求解。
#### 代码：
```java
private List<String> out = new ArrayList<>();

private List<String> in = new ArrayList<>();

private String[] resources = {"", "", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tuv", "wxyz"};



public List<String> letterCombinations(String digits)

{

    if(digits == null || digits.length() == 0 || digits.contains("1") || digits.contains("0"))

        return out;

    char[] c_digits = digits.toCharArray();

    for(char c_digit : c_digits) in.add(resources[c_digit - '0']);

    getString("", 0);

    return out;

}



private void getString(String builder, int index)

{

    char[] chars = in.get(index).toCharArray();

    if(index == in.size() - 1)

        for(char c : chars)

            out.add(builder + c);

    else

        for(char aChar : chars)

            getString(builder + aChar, index + 1);

}

```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode017_LetterCombinationofaPhoneNumber/img/1.png)
