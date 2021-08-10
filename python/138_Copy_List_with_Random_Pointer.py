"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    visitedHash = {}
    
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        old_ptr = head
        new_ptr = Node(old_ptr.val,None,None)
        self.visitedHash[old_ptr] = new_ptr
        self.visitedHash[None] = None
        
        while old_ptr:
            new_ptr.next = Node(old_ptr.next.val,None,None) if old_ptr.next else None
            old_ptr = old_ptr.next
            new_ptr = new_ptr.next
            self.visitedHash[old_ptr] = new_ptr
            
        old_ptr = head
        new_ptr = self.visitedHash[head]
        while old_ptr:
            new_ptr.random = self.visitedHash[old_ptr.random]
            old_ptr = old_ptr.next
            new_ptr = new_ptr.next
            
        return self.visitedHash[head]
        
    
    def copyRandomListIteration(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        def getClonedNode(node):
            if node:
                if node in self.visitedHash:
                    return self.visitedHash[node]
                else:
                    newNode = Node(node.val,None,None)
                    self.visitedHash[node] = newNode
                    return self.visitedHash[node]
            return None
        
        old_ptr = head
        new_ptr = Node(old_ptr.val,None,None)
        self.visitedHash[old_ptr] = new_ptr
        while old_ptr:
            new_ptr.next = getClonedNode(old_ptr.next)
            new_ptr.random = getClonedNode(old_ptr.random)
            old_ptr = old_ptr.next
            new_ptr = new_ptr.next
        return self.visitedHash[head]
    
    def copyRandomListRecursion(self, head: 'Node') -> 'Node':
        if not head:
            return head
        if head in self.visitedHash:
            return self.visitedHash[head]
        
        node = Node(head.val, None, None)
        self.visitedHash[head] = node
        
        node.next = self.copyRandomList(head.next)
        node.random = self.copyRandomList(head.random)
        
        return node
        
        
            
            
            
            
            
        