import org.junit.Test;

import java.util.Arrays;

/**
 * @author yanfa
 * @version 1.0 2016-05-03
 */
public class LeetCode_034_SearchForARange
{
    public int[] searchRange(int[] nums, int target)
    {
        int[] res = new int[]{-1, -1};

        //在nums中进行二分查找，找到target的某一个位置
        //然后在这个位置前后进行范围查找
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
            {
                //寻找下界
                int p = left, q = mid - 1;
                while(p <= q)
                {
                    int r = (p + q) / 2;
                    if(nums[r] == target)
                        q = r - 1;
                    else
                        p = r + 1;
                }
                res[0] = q + 1;

                //寻找上界
                p = mid + 1;
                q = right;
                while(p <= q)
                {
                    int r = (p + q) / 2;
                    if(nums[r] == target)
                        p = r + 1;
                    else
                        q = r - 1;
                }
                res[1] = p - 1;
                break;
            } else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return res;
    }

    @Test
    public void testSearchRange()
    {
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
    }
}