# *题目*
**19. Remove Nth Node From End of List**   
Given a linked list, remove the nth node from the end of list and return its head.  
```
 For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
```
**Note:**  
Given n will always be valid.  
Try to do this in one pass.  
#### 思路：
利用很简单的数据结构知识就可以做出来 。先遍历一遍，找出链表的长度，然后利用长度和给定的n计算要删除的元素的位置，再遍历到该位置，将它删除。注意如果是第一个的话要特殊处理。
#### 代码：
```java
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
```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode019_Remove%20Nth%20Node%20From%20End%20of%20List%20/img/1.png)
