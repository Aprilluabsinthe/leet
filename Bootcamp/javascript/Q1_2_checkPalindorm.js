/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var isAnagram = function(s, t) {
    count = {};
    if(s.length !== t.length){
        return false;
    }
    
    for(let i = 0 ; i < s.length ; i++){
        count[s[i]] = (count[s[i]] || 0) + 1;
    }
    for(let j = 0 ; j < t.length ; j++){
        if(count[t[j]] <= 0){
            return false;
        }
        count[t[j]] -= 1;
    }
    
    for(let k in count){
        if(count[k] > 0){
            return false;
        }
    }
    return true;
    
};