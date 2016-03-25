import org.junit.Test;

import java.util.*;

public class LeetCode_015_3Sum_Update
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i < nums.length-2 && nums[i] <= 0; i++)
        {

            for(int j = nums.length - 1; j > i && nums[j] >= 0; j--)
            {
                int tmp = nums[i] + nums[j];
                int index = Arrays.binarySearch(nums, i + 1, j, -tmp);
                if(index >= 0)
                {
                    lists.add(Arrays.asList(nums[i], -tmp, nums[j]));
                }
                while(i < j && nums[j] == nums[j - 1])
                {
                    j--;
                }
            }
            while(i+1 < nums.length && nums[i] == nums[i + 1])
            {
                i++;
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