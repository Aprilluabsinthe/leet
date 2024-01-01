# Day 6: HashMap Part 01

## Contents:

* [344. Reverse String](#344-reverse-string)
* [541. Reverse String II](#541-reverse-string-ii)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUEtFSGdreWRuR2p4)

<a name="#344-reverse-string"></a>

## [344. Reverse String](https://leetcode.com/problems/reverse-string/)

```java
class Solution {
    public void reverseString(char[] s) {
        int len = s.length;

        // 5-> 5/2=2, 6-> 6/2=3
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
        return;
    }
}
```

**Complexity Analysis**

* Time complexity : O(N) to swap N/2 element.
* Space complexity : O(1), it's a constant space solution.

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
```

<a name="541-reverse-string-ii"></a>

## [541. Reverse String II](https://leetcode.com/problems/reverse-string-ii/)

```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, ch.length - 1);
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
```

**Complexity Analysis**

* Time Complexity: O(N), where NNN is the size of `s`. We build a helper array, plus reverse about half the characters in `s`.
* Space Complexity: O(N), the size of `a`.

## [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

```java
class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");

        for(int i = 0 ; i < ss.length/2 ; i++){
            String temp = ss[i];
            ss[i] = ss[ss.length-i-1];
            ss[ss.length-i-1] = temp;
        }

        return String.join("\s",ss);
  
    }
}
```

## [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

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
