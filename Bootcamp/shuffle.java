// Class of Stacks
// two stacks
// fixed storage

// push pop -> 
// empty peek

// a fixed capacity - n
// n/2
// s1: push 

// n/2
// s2 : pop
// not empty pop()
// is empty 

// array? 
// | 2      | 3       |
// 0       4 5      capa
// 

public class MyStack {
    int capacity;
    int m; // the size of the first stack
    Integer[] array = null ;
    int size1; // keep the num of eles in the stack1
    int size2; // keep the num of eles in the stack2

    public MyStack(int capacity, int m){
        this.capacity = capacity; 
        this.m = m; 
        array = new Integer[capacity];
        size1 = 0;
        size2 = 0;
    }

    // stack 1 : arr[0]-arr[m-1] m -> valid num of eles 
    // stack 2 : arr[m]-arr[capacity-1] capa-m
    // stackID 1,2 

    // 
    public boolean push(int stackID, Integer num){  // 1, 2 // 2,3
        if(stackID == 1){ 
            if(size1 < m){  //size1 < m
                array[size1++] = num; // arr[0] 2, size1 = 1
                return true; 
            }
            return false;
        }else if(stackID == 2){ 
            if(size2 < capacity-m){  // size2 = 0
                array[m+(size2++)] = num; // arr[m] =  3, size2 = 1
                return true; 
            }
            return false;
        }else{
            return false;
        }
    }

    public Integer pop(int stackID){ // 1
        if(stackID == 1){ 
            if(size1 > 0){ // 1
                size1--;  // size1 = 0
                return array[size1]; // array[0] 2
            }
        }else if(stackID == 2){
            if(size2 > 0){
                size2--;
                return array[m+size2]; 
            }
        }
        return null;
    }


}
