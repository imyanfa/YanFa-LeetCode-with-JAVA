# *题目*
Determine if a Sudoku is valid, according to: [Sudoku Puzzles - The Rules](http://sudoku.com.au/TheRules.aspx).  
The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.  
![image](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)  
A partially filled sudoku which is valid.  

**Note:**  
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.  
## 思路：
首先设置三个boolean型的二维标记数组：rowFlags, columnFlags, subFlags，分别对应行、列、子表。   
条件1：数独里面只有是1-9的数字。  
后面的过程就是更新这三个数组，更新过程如下：  
1. 先循环board，在循环的过程中更新。外循环变量为`i`, 内循环变量为`j`。  
2. 每一次内循环计算一个下标：`k = border[i][j] - '1'`，因为条件1，所以`border[i][j]`对应的字符减去1的ASCII码刚好是0-8之间的数。  
3. 对于行，如果`rowFlags[i][k]`为true，则说明前面已经出现过，所以返回false，否则把`rowFlags[i][k]`设为true.   
4. 对于列，如果`columnFlags[j][k]`为true，则说明前面已经出现过，所以返回false，否则把`columnFlags[j][k]`设为true.   
5. 对于子表，如果`subFlags[(i/3)*3 + j/3][k]`，（这里这么计算刚好使行下标处于该位置对应的sub-box中），则说明前面已经出现过，所以返回false，否则把`subFlags[(i/3)*3 + j/3][k]`设为true.   
## 代码：
```java
public boolean isValidSudoku(char[][] board)
{
    final int SIZE = 9;
    boolean[][] rowFlags = new boolean[SIZE][SIZE];
    boolean[][] columnFlags = new boolean[SIZE][SIZE];
    boolean[][] subFlags = new boolean[SIZE][SIZE];
    for(int i = 0; i < SIZE; i++)
    {
        for(int j = 0; j < SIZE; j++)
        {
            if(board[i][j]!= '.')
            {
                int k = board[i][j] - '1';
                if(rowFlags[i][k] || columnFlags[j][k] || subFlags[(i/3)*3 + j/3][k])
                    return false;
                rowFlags[i][k] = columnFlags[j][k] = subFlags[(i/3)*3 + j/3][k] = true;
            }
        }
    }
    return true;
}
```
## 结果细节（图）：
![image](leanote://file/getImage?fileId=572c871f32adcf4b25000000)