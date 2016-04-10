import org.junit.Test;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode_023_MergeKLists
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        int length = lists.length;
        if(length == 0)
            return null;
        if(length == 1)
            return lists[0];
    //        这种方式不如下面的用System.arraycopy高效
    //        ListNode l1 = mergeKLists(Arrays.copyOfRange(lists,0,length/2));
    //        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists,length/2,length));

        ListNode[] subLists1 = new ListNode[length/2];
        ListNode[] subLists2 = new ListNode[length-length/2];
        System.arraycopy(lists,0,subLists1,0,subLists1.length);
        System.arraycopy(lists,subLists1.length,subLists2,0,subLists2.length);
        ListNode l1 = mergeKLists(subLists1);
        ListNode l2 = mergeKLists(subLists2);

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode tmp, head;
        if(l1.val < l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            l2 = l2.next;
        }

        tmp = head;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else
            {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        tmp.next = (l1 == null)?l2:l1;
        return head;
    }

    @Test
    public void fun()
    {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode res = mergeKLists(new ListNode[]{l1,l2});
        while(res!= null)
        {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
