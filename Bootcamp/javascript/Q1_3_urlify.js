var urlify = function(str, length) {
    var strArr = str.split('');
    var pointer = 0;
    while (pointer < str.length) {
      if (strArr[pointer] === ' ') {
        for (var i = str.length - 1; i > pointer + 3; i--) {
          strArr[i] = str[i - 2];
        }
        strArr[pointer] = '%';
        strArr[pointer+1] = '2';
        strArr[pointer+2] = '0';
        console.log(strArr, strArr.length);
      } 
      pointer++;
    }
    return strArr.join('');
  };
  
  var urlify_reverse = function(str, length) {
    var strArr = str.split('');
    var pointer = str.length-1;
    for(let i = length-1; i >= 0; i--){
      if(str.charAt(i)=== ' '){
        strArr[pointer] = '0';
        strArr[pointer-1] = '2';
        strArr[pointer-2] = '%';
        pointer -= 3
      }else{
        strArr[pointer] = str.charAt(i);
        pointer--;
      }
    }
    return strArr.join('');
  };

  console.log(urlify_reverse('Mr John Smith    ', 13), 'Mr%20John%20Smith');