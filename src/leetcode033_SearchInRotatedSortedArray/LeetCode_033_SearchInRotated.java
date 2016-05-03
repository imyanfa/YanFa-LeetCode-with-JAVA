import org.junit.Test;

import java.util.Arrays;

/**
 * @author yanfa
 * @version 1.0 2016-05-02
 */
public class LeetCode_033_SearchInRotated
{
    public int search(int[] nums, int target)
    {
        int pivot = 0;
        while(pivot < nums.length - 1 && nums[pivot] < nums[pivot + 1])
            pivot++;
        int res;
        if(nums[0] <= target)
            res = Arrays.binarySearch(nums,0,pivot+1,target);
        else
            res = Arrays.binarySearch(nums,pivot+1,nums.length,target);
        return res < 0 ? -1 : res;
    }

    @Test
    public void testSearch()
    {
        System.out.println(search(new int[]{1}, 1));
    }

}
