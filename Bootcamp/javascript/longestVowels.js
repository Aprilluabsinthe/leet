process.stdin.resume();
process.stdin.setEncoding('utf-8');

var __input_stdin = "";
var __input_stdin_array = "";

process.stdin.on('data', function(data) {
    __input_stdin += data;
});

function longestSubsequence(s) {
    let vowel = ["a","e","i","o","u"];
    for(v of vowel){
        if(!s.includes(v)){
            return 0;
        }
    }
    
    var dp = new Array(5).fill(0);
    var map = {"a":0,"e":1,"i":2,"o":3,"u":4}
    
    for(let i = 0 ; i < s.length ; i++){
        let index = -1;
        index = map[s[i]];
        if(index == 0){
            dp[index] = dp[index]+1;
        }else{
            if(dp[index-1] === 0){
                continue;
            }
            dp[index] = Math.max(dp[index-1],dp[index])+1;
        }
    }
    
    // console.log(dp);
    return dp[4];
    
    
}

var fs = require('fs');