# *题目*
**21. Merge Two Sorted Lists**  
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

#### 思路：
简单题，利用链表的特点进行合并。
#### 代码：
```java
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
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode021_Merge2Lists/img/1.png)