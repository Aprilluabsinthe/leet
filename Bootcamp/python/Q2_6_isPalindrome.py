class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        value = []
        while head:
            value.append(head.val)
            head = head.next
        
        # print(value)
        # print(value[::-1])
        return (value == value[::-1])