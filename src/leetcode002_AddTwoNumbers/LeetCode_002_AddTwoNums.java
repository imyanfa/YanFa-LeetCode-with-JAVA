import org.junit.Test;

class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}


public class LeetCode_002_AddTwoNums
{

    /**
     * 第一次提交
     * @param l1
     * @param l2
     * @return
     */
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while(pointer1 != null && pointer2 != null)
        {
            int tmp = pointer1.val + pointer2.val;

            if(tmp > 9)
            {
                int x = tmp / 10;
                int y = tmp % 10;
                pointer1.val = pointer2.val = y;
                if(pointer1.next == null && pointer2.next == null)
                {
                    pointer1.next = new ListNode(x);
                    pointer2.next = new ListNode(0);
                }else if(pointer1.next == null)
                {
                    pointer1.next = new ListNode(x);
                }else if(pointer2.next == null)
                {
                    pointer2.next = new ListNode(x);
                }else
                    pointer1.next.val += x;
            } else
            {
                pointer1.val = pointer2.val = tmp;
            }


            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        if(pointer1 == null)
        {
            return l2;
        } else
        {
            return l1;
        }
    }
    */


    /**
     * 第二次提交
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode pointer1Tmp = l1;
        while(pointer1 != null && pointer2 != null)
        {
            int tmp = pointer1.val + pointer2.val;

            if(tmp > 9)
            {
                int x = tmp / 10;
                pointer1.val = tmp % 10;
                if(pointer1.next == null)
                    pointer1.next = new ListNode(x);
                else if(pointer2.next ==null)
                    pointer2.next = new ListNode(x);
                else
                    pointer1.next.val +=x;
            } else
            {
                pointer1.val = pointer2.val = tmp;
            }


            pointer1Tmp = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        if(pointer1 == null)
        {
            pointer1Tmp.next = pointer2;
        }
        return l1;
    }

    @Test
    public void Test()
    {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l1.next = new ListNode(7);
        l2.next = new ListNode(2);
//        l1.next.next = new ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode resutlt = addTwoNumbers(l1, l2);
        while(resutlt != null)
        {
            System.out.print(resutlt.val + " ");
            resutlt = resutlt.next;
        }
    }
}