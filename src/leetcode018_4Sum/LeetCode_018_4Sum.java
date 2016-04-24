import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_018_4Sum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++)
        {
            if(i == 0 || nums[i] != nums[i - 1])
            {
                for(int j = i+1; j < nums.length-2; j++)
                {
                    if(j == i+1 || nums[j] != nums[j-1])
                    {
                        int low = j+1;
                        int high = nums.length-1;
                        int sum = target-nums[i] -nums[j];
                        while(low < high)
                        {
                            if(nums[low]+nums[high] == sum)
                            {
                                lists.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                                while(low < high && nums[low] == nums[low+1]) low++;
                                while(low < high && nums[high] == nums[high-1]) high--;
                                low++;high--;
                            }
                            else if (nums[low] + nums[high] < sum) low++;
                            else high--;
                        }
                    }
                }
            }
        }
        return lists;
    }

    @Test
    public void testFourSum()
    {
        int[] test = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> lists = fourSum(test, 0);
        lists.forEach(e1 -> {
            e1.forEach(e2 -> System.out.print(e2 + " "));
            System.out.println();
        });
    }
}
