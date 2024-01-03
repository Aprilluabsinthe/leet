# Day 8: String Part 01

## Contents

* [344. Reverse String](#344-reverse-string)
* [541. Reverse String II](#541-reverse-string-ii)
* [kama 54](#kama-54)
* [151. Reverse Words in a String](#151)
* [kama 55](#kama-55)
* [28. Find the index of the first occurence](#28)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUGdsY2JFaFhDRVZH)

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

<a name="kama-54"></a>

## Kama 54: replace number

```java
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuffer sb = new StringBuffer();
    
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append("number");
            }else{
                sb.append(s.charAt(i));
            }
        }
    
        System.out.println(sb);
    }
}
```

Note:

Java must use extra space, cuz string is not editable.

But C++ can be done by expand space and add "number" in place.

```cpp
#include<iostream>
using namespace std;
int main() {
    string s;
    while (cin >> s) {
        int count = 0; // 统计数字的个数
        int sOldSize = s.size();
        for (int i = 0; i < s.size(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"number"之后的大小
        s.resize(s.size() + count * 5);
        int sNewSize = s.size();
        // 从后先前将空格替换为"number"
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; i--, j--) {
            if (s[j] > '9' || s[j] < '0') {
                s[i] = s[j];
            } else {
                s[i] = 'r';
                s[i - 1] = 'e';
                s[i - 2] = 'b';
                s[i - 3] = 'm';
                s[i - 4] = 'u';
                s[i - 5] = 'n';
                i -= 5;
            }
        }
        cout << s << endl;
    }
}

```

Complexity

* Time complexity: `O(n)`
* Space complexity: `O(1)`



<a name="151"></a>

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

<a name="28"></a>

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

<a name="kama-55"></a>

## Kama 55. Right Rotation of a String

Approach:

double the original string, then select the correct start and end.

```java
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    
        int k = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
    
        StringBuffer sb = new StringBuffer();
    
        String helperS = s + s;
        int len = s.length();
        int start = len - (k % len);
    
        for(int i = start ; i < start + len && i < 2 * len ; i++){
            sb.append(helperS.charAt(i));
        }
    
    
        System.out.println(sb);
    
    }
}
```



#### C++ in place approach


![illustraion](https://code-thinking-1253855093.file.myqcloud.com/pics/20231106172058.png)
