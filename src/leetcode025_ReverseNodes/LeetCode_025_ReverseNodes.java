import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode_025_ReverseNodes
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(head == null || k == 0 || k == 1)
            return head;
        ListNode flag = head;
        ListNode p,q = null;
        boolean b = true;
        while(flag != null)
        {
            int count;
            p = flag;
            for(count = 0; count < k && flag != null; count++, flag = flag.next) ;  //遍历找到一个k长度的的子链表，其中p记录第一个结点，flag记录最后一个结点的下一个结点
            if(count < k) return head;//如果某个子链表不满足k长度，则返回
            ListNode tmp = reverse(p, flag);  //reverse子链表
            p.next = flag;//注意这里和q是有区别的，如果下一个子链表长度不满足k的话，这是就必须连接起来，否则这个子链表就会丢失。
            if(b)
            {//记录头结点所在位置
                head = tmp;
                b = false;
            }
            if(q!=null)
            {
                q.next = tmp; //连接两个k长度的链表
            }
            q = p;
        }
        return head;
    }

    private ListNode reverse(final ListNode p, final ListNode flag)
    {
        ListNode prev = null, next = p, now = p;
        while(next != flag)
        {
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }


    @Test
    public void testReverseKGroup()
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

        head = reverseKGroup(head, 3);

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
