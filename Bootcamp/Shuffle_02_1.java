//How would you design a stack, 
// in addition to push and pop, 
// has a function min() that returns the minimum element

// push ->
// pop ->
// min -> 

// curMin 

// 2,2
// 8,5
// 10,5
// 5,5

// push -> 2, 2 & cuMin ,update the curMin
// int -> int[2, curMin]
// [value, curMIn]



class minStack{
    private Stack<int[]> stack = new Stack<>();

    public void push(int num){
        if(stack.isEmpty()){
            stack.push(new int[]{num, num});
            return;
        }
        // not empty
        int curMin = stack.peek()[1]; //[value, curMIn]
        curMin = Math.min(curMin,num);
        stack.push(new int[]{num, curMin});
        return;
    }

    public int pop(){
        return stack.pop()[0];//[value, curMIn]
    }

    public int min(){
        // pop?
        return stack.peek()[1];//[value, curMIn]
    }
}


// Testing
// How would you load test a webpage without using any webtools?
// webtools ?
// test -> 

// webpage : shopping site 

// 2000 -> 10,000

// 1. send heavy request to website 
// 2. operations  click buttons / update reviews / reqeust pictures(comments)
// script DOS 
// time window -> {timestamp, failed/success} 
// -------------[----[--]----]--------------------------
// extreme testing : 

// --------------------------------- | -------------------- : request
// ---------------------[dealt with] \\\\\\\\\\\\
// (N*2)

