import org.junit.Test;

import java.util.Arrays;
public class LeetCode_004_FindMedian
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] mergeNums = new int[nums1.length + nums2.length];
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < nums1.length && j < nums2.length; k++)
        {
            if(nums1[i] > nums2[j])
            {
                mergeNums[k] = nums2[j];
                j++;
            } else
            {
                mergeNums[k] = nums1[i];
                i++;
            }
        }
        int[] tmp;
        if(i == nums1.length)
            tmp = Arrays.copyOfRange(nums2, j, nums2.length);
        else if(j == nums2.length)
            tmp = Arrays.copyOfRange(nums1, i, nums1.length);
        else
            tmp = new int[0];
        int m = 0;
        while(k < mergeNums.length)
            mergeNums[k++] = tmp[m++];
        int length = mergeNums.length;
        return length % 2 == 0 ? (mergeNums[length / 2 - 1] + mergeNums[length / 2]) * 1.0 / 2 : mergeNums[length / 2];
    }

    @Test
    public void testFindMedianSortedArrays()
    {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2};
        double res = findMedianSortedArrays(a, b);
        System.out.println(res);
    }
}
