# Day 6: HashMap Part 01

## Contents:

* [454. 4Sum II](#454-4sum-ii)
* [383. Ransom Note](#383-ransom-note)
* [15. 3sum](#15-3-sum)
* [18. 4Sum](#18-four-sum)

## References

[Carl's doc collections](https://docs.qq.com/doc/DUFNjYUxYRHRVWklp)

<!-- TOC --><a name="454-4sum-ii)"></a>

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

<!-- TOC --><a name="383-ransom-note)"></a>

## [383. Ransom Note](https://leetcode.com/problems/ransom-note/)

#### Array Approach

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArrayMap = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            magazineArrayMap[magazine.charAt(i) - 'a'] += 1;
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            magazineArrayMap[ransomNote.charAt(j) - 'a'] -= 1;
            if(magazineArrayMap[ransomNote.charAt(j) - 'a'] < 0){
                return false;
            }
        }

        return true;

    }
}
```

#### HashMap Approach

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> occuranceMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            occuranceMap.put(magazine.charAt(i), occuranceMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            occuranceMap.put(ransomNote.charAt(j), occuranceMap.getOrDefault(ransomNote.charAt(j), 0) - 1);
            if (!occuranceMap.containsKey(ransomNote.charAt(j)) || occuranceMap.get(ransomNote.charAt(j)) < 0) {
                return false;
            }
        }

        return true;

    }
}
```

<!-- TOC --><a name="15-3-sum)"></a>

## [15. 3Sum](https://leetcode.com/problems/3sum/)

#### HashSet Approach

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }
}
```

#### Two Pointers Approach

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // If the minium number is > 0, it's not possible to have triplet suming up to
        // 0;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // dedup
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(i, nums, res);
            }
        }
        return res;
    }

    public void twoSum(int i, int[] nums, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        // [lo,hi] but lo can not equal to high, dedup.
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum < 0){
                lo++;
            }else if(sum > 0){
                hi--;
            }else{
                // sum == 0;
                res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                lo++;
                hi--;
                // deduplicate again.
                while(lo<hi && nums[lo] == nums[lo-1]){
                    lo++;
                }
            }
        }

    }
}
```

**Complexity Analysis**

* Time Complexity: `O(n^2)`. `twoSumII` is `O(n) `and we call it nnn times.
  Sorting the array takes `O(nlog⁡n)`, so overall complexity is `O(nlog{n} + n^2).` This is asymptotically equivalent to `O(n^2)`.
* Space Complexity: from `O(log⁡n)` to `O(n)` depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.

<a name="18-four-sum"></a>

## [18. 4Sum](https://leetcode.com/problems/4sum/)

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        // [-2,-1,0,0,1,2]
        for (int i = 0; i < nums.length; i++) {
            // cut of
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int lo = j + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo++], nums[hi--]));
                        while (lo < hi && nums[lo] == nums[lo - 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi + 1])
                            hi--;
                    }
                }
            }
        }
        return res;
    }
}
```

Remeber how to cut of the cases.
