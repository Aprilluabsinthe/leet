/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
 var setZeroes = function(matrix) {
    const R = matrix.length;
    const C = matrix[0].length;
    
    let clearRowZero = false;
    let clearColZero = false;
    for(let j = 0 ; j < C ; j++){
        if(matrix[0][j] == 0) clearRowZero = true;
    }
    
    for(let i = 0 ; i < R ; i++){
        if(matrix[i][0] == 0) clearColZero = true;
    }
    
    for(let i = 1 ; i < R ; i++){
        for(let j = 1 ; j < C ; j++){
            if(matrix[i][j] == 0){
                [matrix[0][j],matrix[i][0]] = [0,0]
            }
        }
    }
    
    for(let i = 1 ; i < R ; i++){
        if(matrix[i][0] == 0){
            for(let j = 0 ; j < C ; j++){
                matrix[i][j] = 0;
            } 
        }
    }
    
    for(let j = 1 ; j < C ; j++){
        if(matrix[0][j] == 0){
            for(let i = 0 ; i < R ; i++){
                matrix[i][j] = 0;
            } 
        }
    }
    
    if(clearRowZero === true){
        for(let j = 0 ; j < C ; j++){
            matrix[0][j] = 0;
        }
    }
    
    if(clearColZero === true){
        for(let i = 0 ; i < R ; i++){
            matrix[i][0] = 0;
        }
    }
    
    
    
};