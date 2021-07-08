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

# dictionary + doulelinkedNode
class DLNode:
    def __init__(self):
        self.key = 0
        self.value = 0
        self.prev = None
        self.next = None
        
class LRUCache:
    def _add_node(self,node:DLNode) -> None:
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    
    def _remove_node(self,node:DLNode) -> None:
        pre= node.prev
        nxt = node.next
        pre.next = nxt
        nxt.prev = pre
    
    def _move_to_head(self,node:DLNode) -> None:
        self._remove_node(node)
        self._add_node(node)
    
    def _delete_tail(self) -> DLNode:
        real_tail = self.tail.prev
        self._remove_node(real_tail)
        return real_tail

    def __init__(self, capacity: int):
        self.cur_size = 0
        self.capacity = capacity
        self.cache = {}
        self.head = DLNode()
        self.tail = DLNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        res = self.cache[key]
        self._move_to_head(res)
        return res.value;

    def put(self, key: int, value: int) -> None:
        if key not in self.cache:
            new_node = DLNode()
            new_node.key = key;
            new_node.value = value;
            
            self.cache[key] = new_node
            self.cur_size += 1
            self._add_node(new_node);
            
            if self.cur_size > self.capacity:
                tail = self._delete_tail()
                self.cur_size -= 1
                self.cache.pop(tail.key)
        else:
            res = self.cache[key]
            res.value = value
            self._move_to_head(res)
            
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)