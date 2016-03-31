import org.junit.Test;

import java.util.*;

public class LeetCode_015_3Sum_Update
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++)
        {
            if(i == 0 || nums[i] != nums[i-1])
            {
                int low = i+1;
                int high = nums.length-1;
                int sum = -nums[i];
                while(low < high)
                {
                    if(nums[low]+ nums[high] == sum)
                    {
                        lists.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;high--;
                    }
                    else if(nums[low] + nums[high] < sum)
                        low++;
                    else
                        high--;
                }
            }
        }
        return lists;

    }


    @Test
    public void testThreeSum()
    {
        int[] test = new int[]{0,-4,-1,-4,-2,-3,2};


        List<List<Integer>> lists = threeSum(test);
        lists.forEach(e1 -> {
            e1.forEach(e2 -> System.out.printf("%5d", e2));
            System.out.println();
        });
    }
}