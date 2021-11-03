def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
    dummyHead = ListNode(-1)
    dummyHead.next = head
    pre = dummyHead
    cur = head
    nxt = head
    
    while cur:
        while nxt and nxt.val == cur.val:
            nxt = nxt.next

        cur.next = nxt
        pre = cur
        cur = nxt
        nxt = cur
    
    return dummyHead.next