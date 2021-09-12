**Q1**

```Tact Coa
-> tacocat
```

```permutation of a palindrome// ignore space
// alphabet
// upper / lower? both//input: String
// return true/false// char[26] lower case
// iterate chars in string, if space, skip it
// char[char-'a'] ++
// if is a permutation of a palindrome,
// all characters will appear even times , or at most one single character aabcc
```

```java
Tact Coa
-> tacocat

permutation of a palindrome

// ignore space
// alphabet
// upper / lower? both

//input: String
// return true/false

// char[26] lower case
// iterate chars in string, if space, skip it
// char[char-'a'] ++ 
// if is a permutation of a palindrome, 
// all characters will appear even times , or at most one single character aabcc

public isPermutations(String str){
	if(str == null || str.length() == 0) return false;
  
	char[] record = new char[26]; // [ , , , , , , , , , , , ]
  str = str.toLowerCase() // tact coa    8
  
  // time: O(N) 
  // space: char[26], O(1)
  for(int i = 0 ; i < str.length() ; i++){
  	if(str.charAt(i) == ' '){ // 
    	i++;
    }
    if(record[ str.charAt(i) - 'a'] == 0) // { [ a = 0, , c = 0, , , t = 0, , , o = 1, ]
    	record[ str.charAt(i) - 'a']++;
    }else{
    	record[ str.charAt(i) - 'a']--; 
    }
  }
  
  int count = 0;
  for(int j = 0 ; j < 26 ; j++){ 
  	if(record[j] == 1) count++; // o = 1, count = 1
  }
  
  return count <= 1; // true

}



// 3 -> 4 -> 5 -> 1 -> 3 -> 4
// solution: 3 -> 4 -> 5 -> 1 


// input Linked - > out Linked
// null -> null
// same value
// LinedNode(value, next)

// Set(), 
// head -> end, put value to the set
// if node value already in set, delete it
// pre,cur, if cur.value in set
// pre->
// cur->


// 
public deleteDuplicate(LinkedListNode head){
	if(head == null) return head;
  LinkedListNode dummyHead = new LinkedListNode(-1);
  dummyHead.next = head; 
  Set<Integer> set = new HashSet<>();
  // dummy -> head -> p1 -> p2 ------> end -> null
  //   pre     cur    nxt
  
  LinkedListNode pre = dummyHead, cur = head;
  
  while( cur != null ){ // todo : cur.next
    if(set.contains(cur.value) ){
    	// delete the cur
      LinkedListNode nxt = cur.next; // cur.next
      pre.next = nxt;
      cur = nxt;
    }else{
      set.add(cur.value);
      pre = cur;
      cur = cur.next;  
    }
  }
  return dummyHead.next;
}


boolean canMoveTo(int x, int y)
  
// test
// chess board
// boundry check : 
  // x < 0, y < 0 
  // x > length, y > length
  // check(x,y) already be fiiled by chess

// rules for moving ? 
// intensively test it by give many test cases
// 






















```
