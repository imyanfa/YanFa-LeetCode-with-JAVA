import org.junit.Test;


public class LeetCode_027_RomoveElement
{
    public int removeElement(int[] nums, int val)
    {
        int endIndex = nums.length - 1;
        for(int i = 0; i <= endIndex; )
        {
            if(nums[i] == val)
                nums[i] = nums[endIndex--];
            else
                i++;
        }
        return endIndex + 1;
    }

    @Test
    public void testRemoveElement()
    {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
