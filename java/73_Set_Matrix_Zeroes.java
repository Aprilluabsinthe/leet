class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null){
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        Boolean clearCol = false;
        
        for( int i = 0 ; i < rows ; i++ ){
            if(matrix[i][0] == 0){
                clearCol = true;
            }
            for( int j = 1 ; j < cols ; j++ ){
                if( matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for( int i = 1 ; i < rows ; i++ ){
            for( int j = 1 ; j < cols ; j++ ){
                if( matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for( int j = 0 ; j < cols ; j++ ){
                matrix[0][j] = 0;
            }
        }
        
        if(clearCol){
            for( int i = 0 ; i < rows ; i++ ){
                matrix[i][0] = 0;
            }
        }
    }
    
    public void setZeroes1(int[][] matrix) {
        if(matrix == null){
            return;
        }
        
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for( int i = 0 ; i < rows ; i++ ){
            for( int j = 0 ; j < cols ; j++ ){
                if( matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        for( int i = 0 ; i < rows ; i++ ){
            for( int j = 0 ; j < cols ; j++ ){
                if( (rowSet.contains(i) || colSet.contains(j)) && matrix[i][j] != 0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}