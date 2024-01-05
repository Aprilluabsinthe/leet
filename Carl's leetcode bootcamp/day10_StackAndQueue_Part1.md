# Day 9: String Part 02

## Contents

* [232. Implement Queue using Stacks](#232)
* [225. Implement Stack using Queues](#459)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUGdsY2JFaFhDRVZH)

<a name="232"></a>

## [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

```java
class MyQueue {
    public Stack<Integer> in;
    public Stack<Integer> out;

    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        dump();
        return this.out.pop();
    }

    public int peek() {
        dump();
        return this.out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();

    }

    private void dump() {
        if (!this.out.isEmpty())
            return;
        while (!this.in.isEmpty()) {
            this.out.push(in.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

![232.用栈实现队列版本2](https://code-thinking.cdn.bcebos.com/gifs/232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97%E7%89%88%E6%9C%AC2.gif)

<a name="225"></a>

## [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

### Approach 1: 2 Queue = LinkedList()

```java
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

### Approach 2: 2 ArrayDeque()

```java
class MyStack {
    //q1作为主要的队列，其元素排列顺序和出栈顺序相同
    Queue<Integer> q1 = new ArrayDeque<>();
    //q2仅作为临时放置
    Queue<Integer> q2 = new ArrayDeque<>();

    public MyStack() {

    }
    //在加入元素时先将q1中的元素依次出栈压入q2，然后将新加入的元素压入q1，再将q2中的元素依次出栈压入q1
    public void push(int x) {
        while (q1.size() > 0) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (q2.size() > 0) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```

### Approach 2: 1 Queue

```java
class MyStack {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1;
    /** Initialize your data structure here. */
    public MyStack() {
        que1 = new ArrayDeque<>();
    }
  
    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }
  
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        return res;
    }
  
    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }
  
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }
}
```
