import org.junit.Test;

/**
 * @author yanfa
 * @version 1.0 2016-05-04
 */
public class LeetCode_035_SearchInsertPosition
{
    /*
    二分查找。若找到则返回找到的下标。否则返回left的值。
     */
    public int searchInsert(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid-1;
            else
                return mid;
        }
        return left;
    }

    @Test
    public void testSearchInsert()
    {
        System.out.println(searchInsert(new int[]{1,3,5,6},0));
    }
}