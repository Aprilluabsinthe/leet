# Day 9: String Part 02

## Contents

* [28. Find the index of the first occurence](#28)
* [459. Repeated Substring Pattern](#459)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUGdsY2JFaFhDRVZH)

<a name="28"></a>

## [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

### Approch: 2 loops matching

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()) {
                if (allMatch(i, haystack, needle))
                    return i;
            }
        }
        return -1;
    }

    public boolean allMatch(int i, String haystack, String needle) {
        for (int j = 0; j < needle.length(); j++) {
            if (haystack.charAt(j + i) != needle.charAt(j))
                return false;
        }
        return true;

    }
}
```

### Approach 2: KMP Algorithm

![KMP精讲2](https://code-thinking.cdn.bcebos.com/gifs/KMP%E7%B2%BE%E8%AE%B22.gif)

* What can KMP do?
  * String matching
  * example: matching pattern "aabaaf" with string "aabaabaaf"
* Core concept of KMP
  * prefix table
  * what is prefix table here? aabaaf
  * a
  * aa
  * aab
  * aabaa
  * aabaaf
  * **the last char is excepted!**
* How to calculate the longes proper prefix?
  * a -> 0
  * **aa** -> 1
  * aab -> 0
  * **a**ab**a** -> 1
  * **aa**b**aa** -> 2
  * aabaaf -> 0
* How to match using prefix table?
  * aabaaf
  * 010120
* What is NEXT/PREFIX array
  * where to go back to if string and pattern not match
  * 3 approaches:
    * right move the next array
    * -1 for each next array
    * keep next array unchanged

<a name="459"></a>



[459. Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        if (t.substring(1, t.length() - 1).contains(s))
            return true;
        return false;
    }
}
```
