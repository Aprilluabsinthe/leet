# Day 2: Arrays Part 02

## Table of Contents:

1. [977. Squares of a Sorted Array](#977)
2. [209. MInimun Size Subarray Sum](#209)
3. [Spiral Matrix II](#59)

## References

[Carl's article](https://programmercarl.com/%E6%95%B0%E7%BB%84%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html)

## 977. Squares of a Sorted Array <a name="977"></a>

[leetcode link](https://leetcode.com/problems/squares-of-a-sorted-array/description/)

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int left = 0;
        int right = len-1;

        for(int i = len - 1 ; i >= 0 ; i--){
            if(Math.abs(nums[right]) >= Math.abs(nums[left])){
                result[i] = nums[right] * nums[right];
                right--;
            }else{
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
```

**Complexity Analysis**

* Time Complexity: O(N), where N is the length of `A`.
* Space Complexity: O(N)

**Recap**

can use extra space!

Was stucked a little bit for looking for O(1) solutions.

## 209. Minimun Size Subarray Sum<a name="209"></a>

[leetcode link](https://leetcode.com/problems/minimum-size-subarray-sum/https://leetcode.com/problems/remove-element/description/)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        // Total sum
        int sum = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;

        for (int end = 0; end < len; end++) {
            sum += nums[end];
            while(sum >= target){ // shrink the collection
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
```

**Recap**

When seeing "continus subarray", consider sliding window.

How to slide?

Start from different index -> judge the min subarray length for this staring index.

compares the min lengths and get the smallest.

The essential of sliding window is the way we move the starting index.

## 59. Spiral Matrix II <a name="59"></a>

[leetcode link](https://leetcode.com/problems/minimum-size-subarray-sum/https://leetcode.com/problems/remove-element/description/)

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int maxNum = n * n;

        int row = 0;
        int col = 0;
        int layer = 0;

        for (int i = 0; i < maxNum; i++) {
            res[row][col] = i + 1;

            // max: available-1; min: n-available
            // example: layer = 0 ; min = 0(layer) ; max = 2(3-0-1)
            if (row == layer && col < n - layer - 1) {
                col++;
            } else if (col == n - layer - 1 && row < n - layer - 1) {
                row++;
            } else if (row == n - layer - 1 && col > layer) {
                col--;
            } else if (col == layer && row > layer) {
                row--;
                if (row == layer + 1) {
                    layer++;
                }
            }

        }
        return res;
    }
}
```

**Another method**

Use a 4 direction 2D array to control the direction.

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int number = 1;
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // This mindset can be reused for other Problems.
        int col = 0, row = 0;
        int dirSign = 0;

        while (number <= n * n) {
            result[row][col] = number;
            number++;

            int r = Math.floorMod(row + dir[dirSign][0], n);
            int c = Math.floorMod(col + dir[dirSign][1], n);

            // If has value, change direction.
            if (result[r][c] != 0)
                dirSign = (dirSign + 1) % 4;
            row += dir[dirSign][0];
            col += dir[dirSign][1];
        }
        return result;
    }
}
```

## Notes for Today <a name="notes"></a>
