# Day 11: Stack And Queue Part 02

## Contents

* [20. Valid Parentheses](#20)
* [1047. Remove All Adjacent Duplicates In String](#1047)
* [150. Evaluate Reverse Polish Notation](#150)
* ## References

[Carl's doc collections](https://docs.qq.com/doc/DUHh6UE5hUUZOZUd0)

<a name="20"></a>

## [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

### Approach 1: basic if else

```java
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (c == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
```

### Approach 2: use map to store parentheses

```java
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }
}
```

<a name="1047"></a>

## [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

### Approach: use stack, reverse iteration

```java
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() != c)) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();

    }
}
```

### Approach 2: use Deque as Stack

118ms, string + string is time consuming.

```java
class Solution {
    public String removeDuplicates(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}
```

### Approach 3: use StringBuffer as Stack

14ms

```java
class Solution {
    public String removeDuplicates(String s) {
        // 将 res 当做栈
        // 也可以用 StringBuilder 来修改字符串，速度更快
        // StringBuilder res = new StringBuilder();
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
```

### Approach 4: special solution. two pointers

!! think about it! it is overwrite and contril all the characters.

```java
class Solution {
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();

        int fast = 0, slow = 0;

        while (fast < s.length()) {
            ch[slow] = ch[fast];
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);

    }
}
```

<a name="150"></a>

## [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

![150.逆波兰表达式求值](https://code-thinking.cdn.bcebos.com/gifs/150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.gif)



```java
class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> opsSet = new HashSet<>() {
            {
                add("+");
                add("-");
                add("*");
                add("/");
            }
        };
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (opsSet.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = calculate(token, num1, num2);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

    public int calculate(String ops, int num1, int num2) {
        if (ops.equals("+")) {
            return num1 + num2;
        } else if (ops.equals("-")) {
            return num1 - num2;
        } else if (ops.equals("*")) {
            return num1 * num2;
        } else if (ops.equals("/")) {
            return num1 / num2;
        }
        return -1;
    }

}
```

![150.逆波兰表达式求值](https://code-thinking.cdn.bcebos.com/gifs/150.%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B1%82%E5%80%BC.gif)
