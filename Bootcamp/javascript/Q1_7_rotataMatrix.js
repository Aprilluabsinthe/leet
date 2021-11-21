/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
 var rotate = function(matrix) {
    const n = matrix.length;
    for(let i = 0 ; i < Math.floor((n+1)/2); i++){
        for(let j = 0 ; j < Math.floor(n/2);j++){
            var temp = matrix[n-j-1][i];
            matrix[n-j-1][i] = matrix[n-i-1][n-j-1]
            matrix[n-i-1][n-j-1] = matrix[j][n-i-1]
            matrix[j][n-i-1] = matrix[i][j];
            matrix[i][j] = temp;
        }
    }
};