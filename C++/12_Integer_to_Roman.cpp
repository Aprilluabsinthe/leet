class Solution {
public:
    string intToRoman(int num) {
        int values[] =  {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        string romans[] =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        string res;
        for (int i = 0 ; i < 13 ; i++){
            while(num >= values[i]){
                num -= values[i];
                res += romans[i];
            }
        }
        return res;
    }
};

int stringToInteger(string input) {
    return stoi(input);
}

int main() {
    string line;
    while (getline(cin, line)) {
        int num = stringToInteger(line);
        
        string ret = Solution().intToRoman(num);

        string out = (ret);
        cout << out << endl;
    }
    return 0;
}