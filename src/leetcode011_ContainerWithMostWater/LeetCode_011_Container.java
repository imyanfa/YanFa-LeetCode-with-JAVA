import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yanfa on 3/20/16.
 */
public class LeetCode_011_Container
{
//    public int maxArea(int[] height)
//    {
//        int max = 0;
//        for(int i = 0; i < height.length-1; i++)
//        {
//            for(int j = i + 1; j < height.length;j++)
//            {
//                int tmp = (j-i)*Math.min(height[i],height[j]);
//                if(tmp > max ) max = tmp;
//            }
//        }
//        return max;
//    }

    public int maxArea(int[] height)
    {
        int left=0, right=height.length-1;
        int max = 0;
        while(left < right)
        {
            int tmp;
            if(height[left] < height[right])
                tmp = (right-left)*height[left++];
            else
                tmp= (right-left)*height[right--];
            max = Math.max(max,tmp);
        }
        return max;
    }

    @Test
    public void testMaxArea()
    {
        int[] height = new int[15000];
        for(int i = 15000,j=0 ; j < height.length; i--,j++)
        {
            height[j] = i;
        }
        System.out.println(maxArea(height));
    }
}
