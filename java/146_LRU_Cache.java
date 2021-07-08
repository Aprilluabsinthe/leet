// LinkedHashMap
class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }
}

// HashMap + DoubleLinkedNode
class LRUCache {
    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    } 

    private void removeNode(Node node){
        Node pre = node.prev;
        Node nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node deleteTail(){
        Node realTail = tail.prev;
        removeNode(realTail);
        return realTail;
    }

    Map<Integer, Node> cache = new HashMap<>();
    int curSize;
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.curSize = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node search = this.cache.get(key);
        if(search == null){
            return -1;
        }else{
            moveToHead(search);
        }
        return search.value;
    }
    
    public void put(int key, int value) {
        Node search = this.cache.get(key);
        if(search == null){
            Node newnode = new Node();
            newnode.key = key;
            newnode.value = value;

            addNode(newnode);
            cache.put(key,newnode);
            this.curSize++;

            if(this.curSize > this.capacity){
                Node tail = deleteTail();
                this.cache.remove(tail.key);
                curSize--;
            }
        }else{
            search.value = value;
            moveToHead(search);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */