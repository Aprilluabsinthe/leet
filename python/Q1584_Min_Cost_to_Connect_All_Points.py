class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        from queue import PriorityQueue
        caldist = lambda p1, p2 : abs(p1[0]-p2[0])+abs(p1[1]-p2[1])

        pq = PriorityQueue()
        toVisit = set(range(len(points)))
        res = 0

        pq.put([0,0])

        while toVisit:
            cost, cur = pq.get()
            if cur not in toVisit:
                continue
            # not visited
            res += cost
            toVisit.remove(cur)

            for node in toVisit:
                pq.put([caldist(points[node],points[cur]), node])

        return res



    def minCostConnectPoints2(self, points: List[List[int]]) -> int:
        N = len(points)

        adj = collections.defaultdict(list) # adj: {key : [] }
        # node,all it's [cost,neighbours]

        for i in range(N):
            x1,y1 = points[i]
            for j in range(i+1, N):
                x2,y2 = points[j]
                dist = abs(x2-x1) + abs(y2-y1)
                adj[i].append([dist, j])
                adj[j].append([dist, i])
        # print(adj)
        
        result = 0
        visit = set()
        minHeap = [[0,0]] # [cost, point]

        while len(visit) < N:
            cost,i = heapq.heappop(minHeap)
            if i in visit:
                continue
            result += cost
            visit.add(i)
            for [neiCost, nei] in adj[i]:
                if nei not in visit:
                    heapq.heappush(minHeap, [neiCost, nei])
        return result




