class Solution:
    directions = [(0,1),(-1,0),(0,-1),(1,0)]
    dirIdx = 0
    x = 0
    y = 0
    
    def isRobotBounded(self, instructions: str) -> bool: 
        # G, add direction pair
        # L, switch direction, direction index + 1
        # R, switch direction, direction index - 1
        # caution: directions change in circles
        
        def action(instrcution):
            if instrcution == "G":
                self.x += self.directions[self.dirIdx][0]
                self.y += self.directions[self.dirIdx][1]
            elif instrcution == "L":
                # dirIdx += 1
                self.dirIdx = self.dirIdx + 1 if self.dirIdx != 3 else 0
            elif instrcution == "R":
                # dirIdx -= 1
                self.dirIdx = self.dirIdx - 1 if self.dirIdx != 0 else 3
        
        for i in range(len(instructions)):
            action(instructions[i])
        
        if (self.x != 0 or self.y != 0) and self.directions[self.dirIdx] == (0,1):
            return False
        else:
            return True
            
            
                
                
        
        