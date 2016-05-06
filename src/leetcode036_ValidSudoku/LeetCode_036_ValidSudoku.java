import org.junit.Test;

/**
 * @author yanfa
 * @version 1.0 2016-05-04
 */
public class LeetCode_036_ValidSudoku
{
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

    @Test
    public void testIsValidSudoku()
    {
        char[][] board = new char[][]{
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }
}