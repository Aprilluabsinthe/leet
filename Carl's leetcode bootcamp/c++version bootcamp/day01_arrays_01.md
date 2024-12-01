# Day 01

## 704. Binary Search

```
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int num_size = nums.size();
        if (num_size == 0 || target < nums[0] || target > nums[num_size - 1]) {
            return -1;
        }

        int left = 0, right = num_size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

};
```

## 27. remove elements

```
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int num_size = nums.size();
        if (num_size == 0) {
            return 0;
        }
        int left = 0 ;

        for(int right = 0 ; right < num_size ; right++){
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
};
```


### 2 pointers

```
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int num_size = nums.size();
        int left = 0;
        int right = num_size;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
};
```


Why I got this so complex?

* dedup right using while loop.
* adding uncertainty by off-by-one error.

* did not understand the essential part of controlling right and left pointers.

My code:

```
lass Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int num_size = nums.size();
        int left = 0;
        int right = num_size;

        if (num_size == 0) {
            return 0;
        }

        while (right >= 1 && nums[right - 1] == val) {
            right--;
        }
        if (right <= 0) {
            return 0;
        }

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
                while (right >= 1 && nums[right - 1] == val) {
                    right--;
                }
            } else {
                left++;
            }
        }
        return left;
    }
};
```


## 977. Square of a sorted array

---

```
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);
        int left = 0;
        int right = n;
        int index = n - 1;

        while (index >= 0) {
            if (abs(nums[left]) < abs(nums[right - 1])) {
                result[index] = nums[right - 1] * nums[right - 1];
                right--;
            } else {
                result[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return result;
    }
};
```
