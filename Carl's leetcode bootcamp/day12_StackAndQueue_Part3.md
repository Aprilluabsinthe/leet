# Day 12: Stack And Queue Part 03

## Contents

* [239. Sliding Window Maximum](#239)
* [347. Top K Frequent Elements](#347)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUHNpa3F4b2dMUWJ3)

<a name="239"></a>

## [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

![Alt Text](https://assets.leetcode.com/static_assets/posts/sliding_window_maximum.gif)

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();      
    }
}
```

<a name="347"></a>


## [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {// 大顶堆需要对所有元素进行排序
            pq.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {// 依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
```
