var MinStack = function() {
    this.stack = [];
    this.minValue = false; 
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    if(this.minValue===false || val <=this.minValue){
        this.minValue = val;
    }
    this.stack.push([val,this.minValue]);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    let val = this.stack.pop();
    if(val[1]===this.minValue){
        if(this.stack[this.stack.length-1]!==undefined){
            let prevMin = this.stack[this.stack.length-1];
            this.minValue = prevMin[1];
        }else{
            this.minValue=false;
        }
    }
    //return val[0];
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    let val = this.stack[this.stack.length-1];
    return val[0];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    let val = this.stack[this.stack.length-1];
    return val[1];
};