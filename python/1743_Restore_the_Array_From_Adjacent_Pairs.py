class Solution:
    def restoreArray_bfs(self, adjacentPairs: List[List[int]]) -> List[int]:
        graph = collections.defaultdict(set)
        for u,v in adjacentPairs:
            graph[u].add(v)
            graph[v].add(u)
        
        p = list()
        for node in graph:
            if len(graph[node]) == 1:
                p.append(node)
        start = p[0]
        end = p[-1]
        que = [start]
        visited = {start}
        while que:
            cur = que[-1]
            visited.add(cur)
            if cur == end:
                break
            for n in graph[cur]:
                if n not in visited:
                    que.append(n)
        return que
    
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        def dfs(graph,ans,visited,node):
            if node not in visited:
                ans.append(node)
                visited.add(node)
                for subnode in graph[node]:
                    dfs(graph,ans,visited,subnode)

        graph = collections.defaultdict(set)
        for u,v in adjacentPairs:
            graph[u].add(v)
            graph[v].add(u)
        
        p = list()
        for node in graph:
            if len(graph[node]) == 1:
                p.append(node)
        start = p[0]
        ans = []
        dfs(graph,ans,set(),start)
        return ans
