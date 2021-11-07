def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
    R = len(obstacleGrid)
    C = len(obstacleGrid[0])
    memo = [[0 for i in range(C+1)] for _ in range(R+1)]
    
    
    for i in range(1,R+1):
        for j in range(1,C+1):
            if i == 1 and j == 1:
                if obstacleGrid[0][0] != 1:
                        memo[1][1] = 1
                else:
                    return 0
                continue
            if obstacleGrid[i-1][j-1] == 1:
                memo[i][j] = 0
            else:
                memo[i][j] = memo[i-1][j] + memo[i][j-1]
    print(memo)
    return memo[R][C]
    