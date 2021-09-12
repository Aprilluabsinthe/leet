public class Q1_03_URLify {

	public static String replaceSpaces(String str) {
        int trueLength = str.trim().length();
        char[] charStr = str.toCharArray();
        System.out.println("trueLength:" + trueLength + "\n");
        int space = 0;

        for(int i = 0 ; i < trueLength ; i++){
            if(charStr[i] == ' '){
                space++;
            }
        }

        int index = trueLength + space * 2 - 1;

        for(int i = trueLength - 1 ; i >=0 ; i--){
            if(charStr[i] != ' '){
                charStr[index--] = charStr[i];
            }else{
                charStr[index] = '0';
                charStr[index-1] = '2';
                charStr[index-2] = '%';
                index -= 3;
            }
        }

        return new String(charStr);


	}
	
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
        String result = replaceSpaces(str);	
		System.out.println("result:" + result + "\n");
	}
}
