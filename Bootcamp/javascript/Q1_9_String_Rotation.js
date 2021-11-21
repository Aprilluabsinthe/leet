/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
 var rotateString = function(s, goal) {
    if(s.length != goal.length) return false;
    const doubleS = s+s;
    return doubleS.includes(goal);
};