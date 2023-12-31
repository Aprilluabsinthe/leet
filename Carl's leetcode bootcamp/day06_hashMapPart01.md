# Day 6: HashMap Part 01

## Contents:

* [242. Valid Anagram](#242-valid-anagram)
* [349. Intersection of Two Arrays](#349-intersection-of-two-arrays)
* [1. Two Sum](#1-two-sum)
* [454. 4Sum II](#454-4sum-ii)

## References

[Carl's doc collections](https://docs.qq.com/doc/DUFNjYUxYRHRVWklp)

<!-- TOC --><a name="242-valid-anagram"></a>

## [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        // Different length, must not be anagram.
        if (s.length() != t.length()) {
            return false;
        }

        // s and t consist of lowercase English letters.
        int[] charNums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charNums[s.charAt(i) - 'a']++;
            charNums[t.charAt(i) - 'a']--;
        }

        for (int count : charNums) {
            if (count != 0)
                return false;
        }
        return true;

    }
}
```

**Complexity Analysis**

* Time complexity: `O(n)`
  Time complexity is O(n)because accessing the counter table is a constant time operation.
* Space complexity: `O(1)`
  Although we do use extra space, the space complexity is `O(1) `because the table's size stays constant no matter how large `n` is.

**Recap**

a common way : **Frequency Counter**

<!-- TOC --><a name="349-intersection-of-two-arrays"></a>

## [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)

```java
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}
```

<!-- TOC --><a name="1-two-sum"></a>

## [1. Two Sum](https://leetcode.com/problems/two-sum/)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numToIndexMap.containsKey(target - nums[i])) {
                return new int[] { numToIndexMap.get(target - nums[i]), i };
            }
            numToIndexMap.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
```

**Complexity Analysis**

* Time complexity: `O(n)`
  We traverse the list containing nnn elements only once. Each lookup in the table costs only `O(1)` time.
* Space complexity: `O(n)`
  The extra space required depends on the number of items stored in the hash table, which stores at most n elements.


```java
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (true) {
            int sum = getSum(n);
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }

            if (sum == 1) {
                return true;
            }

            n = sum;
        }

    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
```

<!-- TOC --><a name="1-two-sum"></a>

## [454. 4 Sum II](https://leetcode.com/problems/4sum-ii/)

```java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> sumToOccuranceMap1 = new HashMap<>();
        int res = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                sumToOccuranceMap1.put(num1 + num2, sumToOccuranceMap1.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                res += sumToOccuranceMap1.getOrDefault(0 - num3 - num4, 0);
            }
        }
        return res;

    }
}
```
