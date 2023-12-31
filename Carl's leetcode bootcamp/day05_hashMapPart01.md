# Day 5: HashMap Part 01

## Contents:


## References

[Carl's doc collections](https://docs.qq.com/doc/DUFNjYUxYRHRVWklp)

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



<a name="notes"</a>
