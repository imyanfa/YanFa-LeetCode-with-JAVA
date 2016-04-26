import org.junit.Test;

/**
 * @author yanfa
 * @version 1.0 2016-04-25
 */
public class LeetCode_031_NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        //从右向左找到第一个非降序排列的数
        int p = nums.length - 2;
        while(p >= 0 && nums[p] >= nums[p + 1])
            p--;

        //判断若为全降序排列，则交换元素使数组成为全升序排列
        if(p == -1)
        {
            int tmp = nums.length - 1;
            for(int i = 0; i < nums.length / 2; i++)
            {
                nums[i] ^= nums[tmp - i];
                nums[tmp - i] ^= nums[i];
                nums[i] ^= nums[tmp - i];
            }
            return;
        }

        //在p与最后一个元素之间找到一个仅大于nums[p]的数（不能等于nums[p]）
        int q = nums.length - 1;
        while(q > p+1 && nums[q] <= nums[p])
            q--;

        //交换nums[p]与nums[q]
        nums[p] ^= nums[q];
        nums[q] ^= nums[p];
        nums[p] ^= nums[q];

        //将p之后的所有元素按顺序进行排序
        for(int i = p+1, j = nums.length-1; i < j ; i++,j--)
        {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }


    @Test
    public void testNextPermutation()
    {
        nextPermutation(new int[]{3,2,1});
    }
}