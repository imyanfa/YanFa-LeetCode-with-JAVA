# *题目*
**25. Reverse Nodes in k-Group**  
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.  
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.  
You may not alter the values in the nodes, only nodes itself may be changed.  
Only constant memory is allowed.  
For example,  
Given this linked list: `1->2->3->4->5`  
For k = 2, you should return: `2->1->4->3->5`  
For k = 3, you should return: `3->2->1->4->5`
#### 思路：
分段进行反转。具体解释见代码。
#### 代码：
```java
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
        prev =now;
        now = next;
    }
    return prev;
}

```
#### 结果细节（图）：
![imgage](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/src/leetcode025_ReverseNodes/img/1.png)
