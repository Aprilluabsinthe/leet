class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        q = collections.deque()
        
        def clear_deque(index):
            if q and q[0] <= index-k:
                q.popleft()
            while q and nums[q[-1]] < nums[index]:
                q.pop()
        
        max_idx = 0
        for i in range(k):
            clear_deque(i)
            q.append(i)
            if nums[i] > nums[max_idx]:
                max_idx = i
        res = [nums[max_idx]]
        
        for i in range(k,n):
            clear_deque(i)
            q.append(i)
            res.append(nums[q[0]])
        
        return res
                
        
        
    def maxSlidingWindow1(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums
        
        q = collections.deque()
        
        def clean_queue(index):
            if q and q[0] == index-k:
                q.popleft()
            while q and nums[index] > nums[q[-1]]:
                q.pop()
                
        max_idx = 0
        for i in range(k):
            clean_queue(i)
            q.append(i)
            if nums[i] > nums[max_idx]:
                max_idx = i
        output = [nums[max_idx]]
            
        for i in range(k,n):
            clean_queue(i)
            q.append(i)
            output.append(nums[q[0]])
        
        return output