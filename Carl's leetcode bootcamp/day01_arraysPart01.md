# Day 1: Arrays Part 01


## Table of Contents:
1. [Data Structures](#data_structure)
2. [704. Binary Search](#704)
3. [27. Remove Element](#27)

## References
Carl's article link: 

https://programmercarl.com/%E6%95%B0%E7%BB%84%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80.html


## Data Structures <a name="data_structure"></a>

![Arrays](image.png)

An array is a linear data structure that collects elements of the same data type and stores them in contiguous and adjacent memory locations. 

Arrays work on an index system starting from 0 to (n-1), where n is the size of the array.

What Are the Types of Arrays?
There are majorly two types of arrays, they are:

One-Dimensional Arrays: 
![One-Dimensional Arrays](image-1.png)

Two-Dimensional Arrays: 
![Two-Dimensional Arrays](image-2.png)

Three-Dimensional Arrays: 
![Three-Dimensional Arrays](image-3.png)


### How Do You Declare an Array?
![Alt text](image-4.png)

Arrays are typically defined with square brackets with the size of the arrays as its argument.

Here is the syntax for arrays:

> 1D Arrays: int arr[n];
> 
> 2D Arrays: int arr[m][n];
> 
> 3D Arrays: int arr[m][n][o];

### How Do You Initialize an Array?
You can initialize an array in four different ways:

#### Method 1:
<code>int a[6] = {2, 3, 5, 7, 11, 13};</code>

#### Method 2: 
<code>int arr[]= {2, 3, 5, 7, 11};</code>

#### Method 3:
<pre><code>int arr[5];

arr[0]=1;

arr[1]=2;

arr[2]=3;

arr[3]=4;

arr[4]=5;
</code></pre>

## 704. Binary Search <a name="704"></a>
### TD;DR

[leetcode link](https://leetcode.com/problems/binary-search/description/)

1. Include ALL possible answers when initialize lo & hi.
2. Don't overflow the mid calculation.
3. Shrink boundary using a logic that will exclude mid.
4. Avoid infinity loop by picking the correct mid and shrinking logic.
5. Always think of the case when there are 2 elements left.

### The pattern
Some of the most common see questions of Binary Search include:

1. Do I use left or right mid?
2. Do I use < or <= , > or >=?
3. How much do I shrink the boundary? is it mid or mid - 1 or even mid + 1 ?
4. ...

Let's talk about it step by step:

**1. Choice of `lo` and `hi`, aka the boundary.**

Normally, we set the initial boundary to the number of elements in the array

`let lo = 0, hi = nums.length - 1;`

But this is not always the case.

We need to remember: the boundary is the range of elements we will be searching from.

The initial boundary should include **ALL** the elements, meaning all the possible answers should be included. Binary search can be applied to none array problems, such as Math, and this statement is still valid.

**2. Calculate `mid`**
Calculating mid can result in overflow when the numbers are extremely big. 


```java
let mid = Math.floor((lo + hi) / 2) // worst, very easy to overflow

let mid = lo + Math.floor((hi - lo) / 2) // much better, but still possible

let mid = (lo + hi) >>> 1 // the best, but hard to understand
```

When we are dealing with even elements, it is our choice to pick the left mid or the right mid , and as I'll be explaining in a later section, a bad choice will lead to an infinity loop.

```java
let mid = lo + Math.floor((hi - lo) / 2) // left/lower mid

let mid = lo + Math.floor((hi - lo + 1) / 2) // right/upper mid
```

**3. How do we shrink boundary**

Shrinking the boundary should depend on how we define the scope:

If we define scope as`[lowBoundary, highBoundary]` it means both bountries are included.

then we should shrink boundaries like below:

```java
// Mid is already processed. Should be excluded from the next round.
if (target > nums[mid]) {
	lo = mid + 1; // mid is excluded
} else {
	hi = mid - 1; // mid is excluded
}
```

If we define scope as`[lowBoundary, highBoundary)` it means left boundary is included while right boundary is excluded.

then we should shrink boundaries like below:

```java
if (target > nums[mid]) {
	lo = mid + 1; // mid is excluded
} else {
	hi = mid; // hi is included, but right boundary is excluded, which means mid is excluded
}
```

**4. while loop**
To keep the logic simple, I always use

```java
while(lo < hi) { ... }
```

do we need to include <= at all?

Again it goes to our define of the scope:

Assume we only have 2 elements [0,0].
```java
// Define as [left,right].
while(lo <= hi){}
```
[0,0] is an legal scope. So we should consier '=' here.

Assume we only have 2 elements [0,0].

```java
// Define as [left,right).
while(lo < hi){}
```
[0,0) is not an legal scope. So we should exclude '=' here.


**5. Avoid infinity loop**
Remember I said a bad choice of left or right mid will lead to an infinity loop? Let's tackle this down.
Example:

#### calculation of mid
```java
let mid = lo + ((hi - lo) / 2); // Bad! We should use right/upper mid!

if (target < nums[mid]) {
	hi = mid - 1
} else {
	lo = mid; 
}
```

Now, imagine when there are only 2 elements left in the boundary.

We have to keep in mind that, the choice of mid and our shrinking logic has to work together in a way that every time, at least 1 element is excluded.

```java
let mid = lo + ((hi - lo + 1) / 2); // Bad! We should use left/lower mid!

if (target > nums[mid]) {
	lo = mid + 1; // mid is excluded
} else {
	hi = mid; // mid is included
}
```

#### manipulation of pointers
Let's see how the manipulation of pointers will do in leading to an infinity loop:

What we should do:

```java
// Define as [left,right].
let mid = lo + ((hi - lo) / 2);

if (target > nums[mid]) {
	lo = mid + 1; // mid is excluded
} else {
	hi = mid - 1; // mid is excluded
}
```

```java
// Define as [left,right).
let mid = lo + ((hi - lo) / 2);

if (target > nums[mid]) {
	lo = mid + 1; // mid is excluded
} else {
	hi = mid; // mid is excluded
}
```


#### Leetcode 704
For 704 Solution
```java
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        int mid = 0;

        // Define as [left, right]
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // Not found
        return -1;
    }
}
```



## 27. Remove Element <a name="27"></a>
[leetcode link](https://leetcode.com/problems/remove-element/description/)

**Intuition: Fast & Slow Pointers**

The intuition behind this solution is to iterate through the array and keep track of two pointers: `slowIndex` and `fastIndex`. The index pointer represents the position where the next non-target element should be placed, while the i pointer iterates through the array elements. By overwriting the target elements with non-target elements, the solution effectively removes all occurrences of the target value from the array.

**Approach**
Initialize index to 0, which represents the current position for the next non-target element.
Iterate through each element of the input array using the i pointer.

For each element nums[fastIndex], check if it is equal to the target value.

If nums[fastIndex] is not equal to val, it means it is a non-target element.

Set nums[slowIndex] to nums[fastIndex] to store the non-target element at the current index position.

Increment index by 1 to move to the next position for the next non-target element.

Continue this process until all elements in the array have been processed.

Finally, return the value of index, which represents the length of the modified array.
Complexity

**Time complexity:**
O(n)O(n)O(n)

**Space complexity:**
O(1)O(1)O(1)

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for(int fastIndex = 0 ; fastIndex < nums.length ; fastIndex ++){
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
        
    }
}
```
