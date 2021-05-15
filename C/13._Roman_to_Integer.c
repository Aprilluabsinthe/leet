int romanToInt(char * s){
    int romanMap[26];
    romanMap['I'-'A'] = 1;
    romanMap['V'-'A'] = 5;
    romanMap['X'-'A'] = 10;
    romanMap['L'-'A'] = 50;
    romanMap['C'-'A'] = 100;
    romanMap['D'-'A'] = 500;
    romanMap['M'-'A'] = 1000;

    int ans = 0;
    int n = strlen(s);

    for(int i = 0 ; i < n ; i++){
        int value = romanMap[s[i]-'A'];
        if(i < n - 1 && value < romanMap[s[i+1]-'A']){
            ans -= value;
        }
        else{
            ans += value;
        }
    }
    return ans;
}