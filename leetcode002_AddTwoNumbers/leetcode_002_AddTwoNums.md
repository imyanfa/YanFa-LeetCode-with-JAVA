# *题目*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

**Input:** (2 -> 4 -> 3) + (5 -> 6 -> 4)
**Output:** 7 -> 0 -> 8

# *第一次提交*

#### 第一次提交代码：

```java

/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pointer1 = l1;

        ListNode pointer2 = l2;

        while(pointer1 != null && pointer2 != null)

        {

            int tmp = pointer1.val + pointer2.val;

            if(tmp > 9)

            {

                int x = tmp / 10;

                int y = tmp % 10;

                pointer1.val = pointer2.val = y;

                if(pointer1.next == null && pointer2.next == null)

                {

                    pointer1.next = new ListNode(x);

                    pointer2.next = new ListNode(0);

                }else if(pointer1.next == null)

                {

                    pointer1.next = new ListNode(x);

                }else if(pointer2.next == null)

                {

                    pointer2.next = new ListNode(x);

                }else

                    pointer1.next.val += x;

            } else

            {

                pointer1.val = pointer2.val = tmp;

            }

            pointer1 = pointer1.next;

            pointer2 = pointer2.next;

        }



        if(pointer1 == null)

        {

            return l2;

        } else

        {

            return l1;

        }

    }

}

```

#### 第一次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode002_AddTwoNumbers/img/1.png)

#### 第一次提交总结：

考虑到要返回同样的结构的链表，故每一位计算后直接同时赋值给l1，l2，返回值时，哪个链表还有值就返回哪个。再判断进位时比较次数过多，还有优化的空间。



# *第二次提交*

#### 第二次提交代码：

```java

/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pointer1 = l1;

        ListNode pointer2 = l2;

        ListNode pointer1Tmp = l1;

        while(pointer1 != null && pointer2 != null)

        {

            int tmp = pointer1.val + pointer2.val;



            if(tmp > 9)

            {

                int x = tmp / 10;

                pointer1.val = tmp % 10;

                if(pointer1.next == null)

                    pointer1.next = new ListNode(x);

                else if(pointer2.next ==null)

                    pointer2.next = new ListNode(x);

                else

                    pointer1.next.val +=x;

            } else

            {

                pointer1.val = pointer2.val = tmp;

            }

            pointer1Tmp = pointer1;

            pointer1 = pointer1.next;

            pointer2 = pointer2.next;

        }

        if(pointer1 == null)

        {

            pointer1Tmp.next = pointer2;

        }

        return l1;

    }

}

```

#### 第二次结果细节（图）：
![image](https://github.com/jnuyanfa/YanFa-LeetCode-with-JAVA/blob/master/leetcode002_AddTwoNumbers/img/2.png)

#### 第二次提交总结：

效率毫无提升！！！


