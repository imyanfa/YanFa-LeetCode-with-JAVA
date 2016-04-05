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

public class LeetCode_021_MergeLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode p1 = l1, p2 = l2;
        ListNode p3, l3;
        p3 = l3 = new ListNode(0);//注意这里，设一个头节点，方便操作
        l3.next = l1;
        while(p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                p3.next = p1;
                p3 = p1;
                p1 = p1.next;
            } else
            {
                p3.next = p2;
                p3 = p2;
                p2 = p2.next;
            }
        }
        p3.next = p1==null ? p2 : p1;

        return l3.next; //因为我们设了一个头节点，所以要跳过头节点

    }

    @Test
    public void testMergeTwoLists()
    {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        for(int i = 9; i > 1; i--)
        {
            ListNode tmp = new ListNode(i);
            if(i % 2 == 0)
            {
                tmp.next = l1.next;
                l1.next = tmp;
            } else
            {
                tmp.next = l2.next;
                l2.next = tmp;
            }
        }

        System.out.print("l1: ");
        ListNode tmp = l1;
        while(tmp != null)
        {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.print("\nl2: ");
        tmp = l2;
        while(tmp != null)
        {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.print("\nres: ");
        ListNode res = mergeTwoLists(l1, l2);
        tmp = res;
        while(tmp != null)
        {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}