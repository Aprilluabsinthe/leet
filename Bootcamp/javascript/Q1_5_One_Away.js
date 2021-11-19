/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 var isAdd = function(shorter, longer){
    for(let i = 0 ; i < shorter.length ; i++){
        if(shorter.charAt(i)!=longer.charAt(i)){
            return shorter.substr(i) === longer.substr(i+1);
        }
    }
    return true;
}

var isEdit = function(s1, s2){
    for(let i = 0 ; i < s1.length ; i++){
        if(s1.charAt(i)!=s2.charAt(i)){
            return s1.substr(i+1) === s2.substr(i+1);
        }
    }
    return false;
}


var isOneEditDistance = function(s, t) {
    const lens = s.length;
    const lent = t.length;
    if(Math.abs(lens-lent) > 1) return false;
    
    if(lens > lent){
        return isOneEditDistance(t,s);
    }
    
    if(lent - lens === 1){
        return isAdd(s,t);
    }
    else if(lent === lens){
        return isEdit(s,t);
    }
    
    return false;
};