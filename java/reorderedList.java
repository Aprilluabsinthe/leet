import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;
    
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

    static LinkedListNode reorderList(LinkedListNode head) {
        if(head == null){
            return null;
        }
        
        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;
        LinkedListNode preEnd = splitList(dummy);
        LinkedListNode secondHead = preEnd.next;
        preEnd.next = null;
        
        // System.out.format("secondHead.val : %d %n",secondHead.val);
        
        LinkedListNode newSecondHead = reverse(secondHead);
        // System.out.format("newSecondHead.val : %d %n",newSecondHead.val);
        
        interval(head,newSecondHead);
        // System.out.format("result.val : %d %n",result.val);
        
        return head;
    }
    
    static LinkedListNode splitList(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static LinkedListNode reverse(LinkedListNode head){
        LinkedListNode pre = null, cur = head, nxt = head;
        while(cur!=null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    
    static LinkedListNode interval(LinkedListNode l1,LinkedListNode l2){
        LinkedListNode pointer1 = l1, nxt1 = l1;
        LinkedListNode pointer2 = l2, nxt2 = l2;
        LinkedListNode cur = null;
        
        while( pointer1 != null && pointer2 != null){
            nxt1 = pointer1.next;
            nxt2 = pointer2.next;
            pointer1.next = pointer2;
            pointer2.next = nxt1;
            cur = pointer1;
            pointer1 = nxt1;
            pointer2 = nxt2;
        }
        if( pointer2 != null ){
            cur.next = pointer2;
        }
        return l1;
    }
    
    static LinkedListNode recursionReorder(LinkedListNode l1, LinkedListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        LinkedListNode temp = l1.next;
        l1.next = l2;
        recursionReorder(l2, temp);
        return l1;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _head_size = _head_size = Integer.parseInt(in.nextLine());
        LinkedListNode _head = null;
        LinkedListNode _tail = null;
        for (int _head_i = 0; _head_i < _head_size; _head_i++) { 
            int _item;
            try {
                _item = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                _item = -1 ;
            }
            if (_tail != null) {
                _tail.next = new LinkedListNode(_item);
                _tail = _tail.next;
            } else
                _tail = _head = new LinkedListNode(_item);
        }
        
        LinkedListNode newHead = reorderList(_head);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}