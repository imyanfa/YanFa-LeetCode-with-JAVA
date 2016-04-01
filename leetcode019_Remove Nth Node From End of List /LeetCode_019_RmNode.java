class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}

public class LeetCode_019_RmNode
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode tmp = head;
        int length = 0;
        while(tmp != null)
        {
            length++;
            tmp = tmp.next;
        }

        int pos = length - n + 1;
        tmp = head;
        if(pos == 1)
            return head.next;
        int i = 1;
        while(tmp != null)
        {
            if(++i == pos)
            {
                tmp.next = tmp.next.next;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }

}