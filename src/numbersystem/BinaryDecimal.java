package numbersystem;

import static java.lang.Math.pow;

public class BinaryDecimal {
    public static void main(String[] args) {
        int number = getDecimalFromSignedBinary("11111111");
        System.out.println(number);
    }

    public static int getDecimalFromSignedBinary(String binaryNum){
        int symbol = 1;
        int intNum = 0;
        char[] binaryArray = binaryNum.toCharArray();
        int len = binaryArray.length;
        if(binaryArray[0] == '1'){
            binaryArray = getTwosComplement(binaryArray);
            symbol = -1;
        }
//        System.out.println(binaryArray);
        for (int i = 1; i < len; i++) {
            int power = len - i - 1;
            int digit = binaryArray[i] - '0';
            intNum += (digit * pow(2, power));
        }
        if (symbol == -1 && intNum == 0){
            intNum = (int) pow(2, len - 1);
        }
        return intNum * symbol;
    }

    public static char[] getTwosComplement(char[] num){
        int len = num.length;
        boolean found1 = false;
        for (int i = len-1; i >= 0; i--) {
            if (found1)
                num[i] = (char) ('1' - num[i] + '0');
            if (num[i] == '1')
                found1 = true;
        }
        return num;
    }
}
