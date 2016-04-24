import org.junit.Test;

import java.util.Arrays;

public class LeetCode_016_3SumClosest
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int[] flags = {-1, 1};
        for(int a = 0; ; a++)
        {
            for(int b = 0; b < 2; b++)
            {
                int _target = target + a * flags[b];
                for(int c = 0; c < nums.length - 2; c++)
                {
                    int low = c+1;
                    int high = nums.length-1;
                    while(low < high)
                    {
                        int sum = nums[c] + nums[low] + nums[high];
                        if(sum == _target) return _target;
                        if(sum < _target) low++;
                        else if(sum > _target) high--;
                    }
                }
            }
        }
    }


    @Test
    public void testThreeSum()
    {
        int[] test = new int[]{0,0,0};
        System.out.println(threeSumClosest(test, 2));
    }
}