import org.junit.Test;

import java.util.*;
public class LeetCode_015_3Sum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                for(int k = j + 1; k < nums.length; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    while(k+1 < nums.length&& nums[k] == nums[k+1])
                        k++;
                }
                while(j+1 < nums.length&& nums[j] == nums[j+1])
                    j++;
            }
            while(i+1 < nums.length&& nums[i] == nums[i+1])
                i++;
        }
        return lists;
    }


    @Test
    public void testThreeSum()
    {
        int[] test = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};

        List<List<Integer>> lists = threeSum(test);
        lists.forEach(e1 -> {
            e1.forEach(e2 -> System.out.printf("%5d", e2));
            System.out.println();
        });
    }
}
