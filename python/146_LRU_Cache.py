from collections import OrderedDict
class LRUCache(OrderedDict):

    def __init__(self, capacity: int):
        self.capacity = capacity # self is a container of OrderedDict

    def get(self, key: int) -> int:
        if key not in self:
            return -1
        self.move_to_end(key,last=True) # move the recently visited one to the right end
        return self[key]

    def put(self, key: int, value: int) -> None:
        if key in self:
            self.move_to_end(key,last=True)# move the recently visited one to the right end
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False)# pop from left end



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)