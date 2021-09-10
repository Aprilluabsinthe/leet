class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = [(target-pos,spd) for (pos,spd) in zip(position,speed)]
        cars = sorted(cars)
        print(cars)
        
        fleet = 0
        slowest = 0
        for i in range(len(cars)):
            time = cars[i][0] / cars[i][1]
            if time > slowest:
                fleet += 1
                slowest = time
        
        return fleet