import org.junit.Test;

import java.util.*;

public class LeetCode_001_TwoSum
{

    /**
     * 第一次
     * @param nums
     * @param target
     * @return
     */
    /*
    public int[] twoSum(int[] nums, int target)
    {

        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = i+1; j< nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    */

    /**
     * 第二次
     * @param nums
     * @param target
     * @return
     */
    /*
    public int[] twoSum(int[] nums, int target)
    {
        //map用来记录原数组的值与下标的关系
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++ )
            map.put(i,nums[i]);

        //对数组进行排序
        Arrays.sort(nums);

        //得到目标值数组
        List<Integer> targerNumbers = new ArrayList<>();

        int[] targerIndex = new int[]{-1,-1};

        {
            //核心代码
            int i=0, j = length-1;
            while(i < j)
            {
                int tmp = nums[i]+nums[j];
                if(tmp == target)
                {
                    targerNumbers.add(nums[i]);
                    targerNumbers.add(nums[j]);
                    break;
                }else if(tmp < target)
                    i++;
                else
                    j--;
            }
        }
        //返回目标下标
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue().equals(targerNumbers.get(0)) && targerIndex[0]==-1)
                targerIndex[0] = entry.getKey();
            else if(entry.getValue().equals(targerNumbers.get(1)) && targerIndex[1]==-1)
            {
                targerIndex[1] = entry.getKey();
            }

        }
        return targerIndex;
    }
    */


    /**
     * 第三次
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target)
    {

        int[] targerIndex = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                targerIndex[0] = map.get(nums[i]);
                targerIndex[1] = i;
                break;
            } else
            {
                map.put(target - nums[i], i);
            }
        }

        return targerIndex;
    }

    @Test
    public void fun()
    {
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int[] result = twoSum(nums, -8);
        for(int i : result)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
