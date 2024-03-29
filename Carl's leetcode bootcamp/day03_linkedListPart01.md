# Day 3: Linked List Part 01

## Contents:

1. [203. Remove Linked List Elements](#203)
2. [707. Design Linked List](#707)
3. [206. Reverse Linked List](#206)

## References

[Carl's doc collections](https://docs.qq.com/doc/DUGdqYWNYeGhlaVR6)

## 203. Remove Linked List Elements<a name="203"></a>

[leetcode link](https://leetcode.com/problems/remove-linked-list-elements/)

**Algorithm**

* Initiate the sentinel node as `ListNode(0)` and set it to be the new head: `sentinel.next = head`.
* Initiate two pointers to track the current node and its predecessor: `curr` and `prev`.
* While `curr` is not a null pointer:
  * Compare the value of the current node with the value to delete.
    * If the values are equal, delete the current node: `prev.next = curr.next`.
    * Otherwise, set the predecessor to be equal to the current node.
  * Move to the next node: `curr = curr.next`.
* Return `sentinel.next`.

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = new ListNode(-1, head);
        ListNode dummyHead = pre;

        while (cur != null) {
            ListNode nxt = cur.next;
            if (cur.val == val) {
                pre.next = nxt;
            } else {
                pre = pre.next;
            }
            cur = cur.next;

        }

        return dummyHead.next;
    }
}
```

**Recap**

Use dummyHead.

## 707. Design Linked List<a name="707"></a>

[leetcode link](https://leetcode.com/problems/design-linked-list/)

```java
public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class MyLinkedList {
  int size;
  ListNode head;  // sentinel node as pseudo-head
  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    // If index is invalid
    if (index < 0 || index >= size) return -1;

    ListNode curr = head;
    // index steps needed 
    // to move from sentinel node to wanted index
    for(int i = 0; i < index + 1; ++i) curr = curr.next;
    return curr.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    // If index is greater than the length, 
    // the node will not be inserted.
    if (index > size) return;

    // [so weird] If index is negative, 
    // the node will be inserted at the head of the list.
    if (index < 0) index = 0;

    ++size;
    //Find predecessor of the node to be added
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // node to be added
    ListNode toAdd = new ListNode(val);
    // insertion itself
    toAdd.next = pred.next;
    pred.next = toAdd;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    // If the index is invalid, do nothing
    if (index < 0 || index >= size) return;

    size--;
    //Find predecessor of the node to be deleted
    ListNode pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;

    // delete pred.next 
    pred.next = pred.next.next;
  }
}
```

**Recap**

Shoud define the simple LinkedListed sturcture outside the customized class.

This is a designing problem, might not be common when interviewing, but is a good challenge for overall designning.

```java
class MyLinkedList {

    public int size;

    public int val;

    public MyLinkedList next;

    public MyLinkedList dummyHead;

    public MyLinkedList(int val, MyLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public MyLinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    public MyLinkedList() {
        this.size = 0;
        this.dummyHead = new MyLinkedList(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        MyLinkedList cur = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        newNode.next = this.dummyHead.next;
        this.dummyHead.next = newNode;
        this.size += 1;
    }

    public void addAtTail(int val) {
        // Get tail
        MyLinkedList cur = this.dummyHead.next;
        MyLinkedList pre = this.dummyHead;

        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }

        // Now pre is the last element, cur is null
        pre.next = new MyLinkedList(val);
        this.size += 1;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            return;
        }
        MyLinkedList cur = this.dummyHead.next;
        MyLinkedList pre = this.dummyHead;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = new MyLinkedList(val, cur);
        this.size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        MyLinkedList cur = this.dummyHead.next;
        MyLinkedList pre = this.dummyHead;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = cur.next;
        this.size -= 1;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

## 206. Reverse Linked List<a name="206"></a>

[leetcode link](https://leetcode.com/problems/minimum-size-subarray-sum/https://leetcode.com/problems/remove-element/description/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode nxtTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxtTemp;
        }
        return pre;
    }
}
```

**Complexity analysis**

* Time complexity : O(n)
  Assume that nnn is the list's length, the time complexity is O(n)
* Space complexity : O(1)

## Notes for Today <a name="notes"></a>

```java
// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

```
