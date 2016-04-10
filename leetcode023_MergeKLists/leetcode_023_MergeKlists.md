# *题目*
**23. Merge k Sorted Lists**   
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
#### 思路：
利用分治法（递归）思想，再加合并两个链表的思路这题就迎刃而解了。
#### 代码：
```java
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

```
#### 结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode023_MergeKLists/img/1.png)
# *总结：*
JAVA中拷贝数组可以用System.arraycopy和Arrays.copyOf()，但是Arrays.copyOf()的底层实现还是用的System.arraycopy，所以在本题中用System.arraycopy比较高效一点。