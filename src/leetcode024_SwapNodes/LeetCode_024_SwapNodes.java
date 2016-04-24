import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode_024_SwapNodes
{
    public ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode tmp = new ListNode(0); //始终指向要交换的两个元素的前一个，方便进行操作
        ListNode p = head;
        ListNode q = head.next;
        head = q; //注意交换后头结点会变，在这里记录头结点
        do
        {
            tmp.next = q;
            p.next = q.next;
            q.next = p;
            tmp = p;
            p = p.next;
            q = (p == null) ? null : p.next;
        } while(q != null);
        return head;
    }

    @Test
    public void testMergeTwoLists()
    {
        ListNode head = new ListNode(0);
        for(int i = 9; i >= 1; i--)
        {
            ListNode tmp = new ListNode(i);
            tmp.next = head.next;
            head.next = tmp;
        }

        System.out.print("before: \n");
        ListNode tmp = head;
        while(tmp != null)
        {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }

        head = swapPairs(head);

        System.out.print("\nafter: \n");
        tmp = head;
        while(tmp != null)
        {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}