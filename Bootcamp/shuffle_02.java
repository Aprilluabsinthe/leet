// You are given two sorted array: A, and B, 
// where A has a large enough buffer at the end to hold B. 
// Write a method to merge A, B, in sorted order.

// A[] 
// input: Arrays A B -> integers
// output: Arrays A inplace?
// lenA ?-> A = [1, 2, 3, 0. 0. 0], n = 3
// lenA ?-> B = [4, 7, 8], m = 3


public class shuffle_02 {
    public void mergeArrays(int[] A, int B[] ,int lenA, int lenB){
        // lenth of A
        int len_total_A = lenA + lenB;
        int pointB = lenB-1; // A = [1, 2, 0. 0. 0] len 2
        int pointA = lenA-1; // B = [4, (1), 8] len 3
        int pointEnd = len_total_A-1; // A = [1, 2, 3, 0. (3). (8)]

        // time O(lenA+LenB)
        // space O(1)
        
        // interate B from end to start 
        while(pointB >= 0){ // Todo : find A's limatation of range
            if(pointerA >= 0 && A[pointerA] > B[pointerB]){ // A[pointerA] > B[pointerB]
                // what if 
                A[pointEnd--] = A[pointerA--];
            } 
            else{// 3 8
                A[pointEnd--] = B[pointerB--];
            }
        }
    }
}
