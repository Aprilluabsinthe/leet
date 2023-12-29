# Day 4: Linked List Part 02

## Contents:

1. [24. Swap Nodes in Pairs](#24)
2. [19. Remove Nth Node From End of List](#19)
3. [160. Intersection Of Two Linked List](#160)
4. [142. Linked List Cycle II](#142)

## References

[Carl's doc collections](https://docs.qq.com/doc/DUFNjYUxYRHRVWklp)

## 24. Swap Nodes in Pairs<a name="24"></a>

[leetcode link](https://leetcode.com/problems/swap-nodes-in-pairs/)

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead, cur = head, nxt = head.next;

        while (cur != null && cur.next != null && nxt != null) {
            pre.next = nxt;
            cur.next = nxt.next;
            nxt.next = cur;
            pre = cur;
            cur = cur.next;
            nxt = (cur != null && cur.next != null) ? cur.next : null;
        }

        return dummyHead.next;
    }
}
```

**Recap**

Pay attention to the nulls.

`next = cur.next.next`, nees to judge nulls carefully.

the Answer uses `head` directly as the pointer to make the swap.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
```

## 19. Remove Nth Node From End <a name="19"></a>

[leetcode link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1, head);
        ListNode dummyHeadPre = new ListNode(-2, dummyHead);

        ListNode preSlowPoint = dummyHeadPre, slowPoint = dummyHead, fastPoint = dummyHead;

        // Move fast pointer n steps away from slowPointers.
        for (int i = 0; i < n; i++) {
            if (fastPoint.next != null) {
                fastPoint = fastPoint.next;
            } else {
                // no Nth node from end;
                return head;
            }
        }

        // Moves all pointers unil fast point reaches the end.
        while (fastPoint != null) {
            preSlowPoint = preSlowPoint.next;
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }

        // delete slowPointer(aka Nth Node)
        preSlowPoint.next = slowPoint.next;

        return dummyHead.next;

    }
}
```

**Recap**

1. Maintain two pointers and update one with a delay of n steps.
2. If `fast` is N ahead of `slow`, needs to maintain a `prev` node; To be simple, we can do `fast` is N+1 ahead of `slow`(aka gap is N).
3. `slow` and `fast` should start from `dummy`, not `head`. Otherwise we will miss the first node.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1, head);
        ListNode slowPoint = dummyHead, fastPoint = dummyHead;

        // Move fast pointer n steps away from slowPointers.
        for (int i = 0; i <= n; i++) {
            if (fastPoint != null) {
                fastPoint = fastPoint.next;
            } else {
                // no Nth node from end;
                return head;
            }
        }

        // Moves all pointers unil fast point reaches the end.
        while (fastPoint != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }

        // delete slowPointer(aka Nth Node)
        slowPoint.next = slowPoint.next.next;

        return dummyHead.next;

    }
}
```

## 160. Intersection Of Two Linked List<a name="160"></a>

[leetcode link](https://leetcode.com/problems/minimum-size-subarray-sum/https://leetcode.com/problems/remove-element/description/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;

        while (true) {
            // Find intersection.
            if (pA == pB) {
                return pA;
            }
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
    }
}
```

**Recap**

It is a classic problem in linked List.

Use two pointers. cycleIn the case lists do not intersect, the pointers for A and B will still line up in the 2nd iteration, just that here won't be a common node down the list and both will reach their respective ends  at the same time. So pA will be NULL in that case.

![Diagram showing that one pointer could go over a + c + b while the other goes over b + c + a, and then both will end up on the intersection node.](https://leetcode.com/problems/intersection-of-two-linked-lists/Figures/160/image4.png)

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
```

Let N be the length of list A and M be the length of list B.

* Time complexity : O(N+M).
  In the worst case, each list is traversed **twice** giving 2⋅M+2⋅N, which is equivalent to O(N+M). This is because the pointers firstly go down each list so that they can be "lined up" and then in the second iteration, the intersection node is searched for.
  An interesting observation you might have made is that when the lists are of the same length, this algorithm only traverses each list **once**. This is because the pointers are already "lined up" from the start, so the additional pass is unnecessary.
* Space complexity : O(1)

## 142. Linked List Cycle II<a name="142"></a>

[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

### Approach 1: Easy solution. use hashSet

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            // No Cycle.
            return null;
        }

        Set<ListNode> nodeSet = new HashSet<>();

        while(head!=null){
            if(nodeSet.contains(head)){
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return null;
    }
}
```


#### Complexity Analysis

Let nnn be the total number of nodes in the linked list.

* Time complexity: O(n)

We have to visit all nodes once.

* Space complexity: O(n)

We have to store all nodes in the hash set.



### Approach 2: Floyd's Tortoise and Hare Algorithm


#### Algorithm

1. Initialize the `tortoise` and `hare` pointers to the head of the linked list.
2. Move the `tortoise` one step and the `hare` two steps at a time until they meet or either `hare` or `hare.next` becomes `null`.
3. If the `hare` or `hare.next` pointer is `null`, it means the hare came to the dead end and we return `null` as there is no cycle.
4. Reset the `hare` pointer to the head of the linked list.
5. Move both pointers one step at a time until they meet again. The meeting point is the node where the cycle begins.
6. Return the meeting point node.

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize tortoise and hare pointers
        ListNode tortoise = head;
        ListNode hare = head;

        // Move tortoise one step and hare two steps
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // Check if the hare meets the tortoise
            if (tortoise == hare) {
                break;
            }
        }

        // Check if there is no cycle
        if (hare == null || hare.next == null) {
            return null;
        }

        // Reset either tortoise or hare pointer to the head
        hare = head;

        // Move both pointers one step until they meet again
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        // Return the node where the cycle begins
        return tortoise;
    }
}
```

## Notes for Today <a name="notes"></a>
