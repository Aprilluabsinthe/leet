class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        from queue import PriorityQueue
        q = PriorityQueue()
        
        for stone in stones:
            q.put(-stone)
        
        while not q.empty():
            if q.qsize() == 1:
                return -1*q.get()
            bigone = q.get()
            smallone = q.get() if not q.empty() else 0
            newone = bigone-smallone
            q.put(newone)
        
        return 0
            
        
        
        