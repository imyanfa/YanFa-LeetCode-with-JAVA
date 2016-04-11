# *题目*
**24. Swap Nodes in Pairs**  
Given a linked list, swap every two adjacent nodes and return its head.  
 For example,  
Given `1->2->3->4`, you should return the list as `2->1->4->3`.  
 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.  
#### 思路：
本题较简单，用链表的特性求解。有两个要点：1. 提前记录头结点，以防交换后头结点还指向原来的位置导致头结点丢失；2. 每次交换结束后要记下不上不下次要交换的结点的前一个结点。
#### 代码：
```java
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
```
#### 结果细节（图）：
![image]()