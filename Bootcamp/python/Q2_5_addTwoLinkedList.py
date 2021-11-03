def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    p1 = l1
    p2 = l2
    dummyHead = ListNode(-1)
    p3 = dummyHead
    carry = 0
    while p1 or p2:
        p1val = p1.val if p1 else 0
        p2val = p2.val if p2 else 0
        nodeSum = p1val + p2val + carry
        carry = nodeSum // 10
        nodeSum = nodeSum % 10

        p3.next = ListNode(nodeSum)
        p3 = p3.next
        p1 = p1.next if p1 else None
        p2 = p2.next if p2 else None
    if carry:
        p3.next = ListNode(carry)
    return dummyHead.next