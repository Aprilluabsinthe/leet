var canPermutePalindrome = function(s) {
    const map = new Map();
    for(let i = 0 ; i < s.length ; i++){
        if(!map[s[i]] || map[s[i]] == 0){
            map[s[i]] = 1;
        }else{
            map[s[i]] -= 1;
        }
    }
    let count = 0;
    for(let key in map){
        if(map[key]!=0){
            count++;
        }
        if(count > 1){
            return false;
        }
    }
    return true;
};

var canPermutePalindrome = function(s) {
    const n = s.length;
    const map = new Map();
    for(c of s){
        const count = map.has(c) ? map.get(c):0;
        map.set(c,count+1);
    }
    let oddCount = 0;
    for(const [key,val] of map){
        if(val % 2 !== 0) oddCount++;
    }
    return oddCount<=1;
}