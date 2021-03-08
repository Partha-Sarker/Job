package numbersystem;

import java.util.ArrayList;
import java.util.Collections;

public class DecimalBinary {
    public static void main(String[] args) {
        int num = -128;
        String binaryString = getBinaryFromDecimal(num, 8);
        int converted = BinaryDecimal.getDecimalFromSignedBinary(binaryString);
        System.out.println(num);
        System.out.println(binaryString);
        System.out.println(converted);
    }

    private static String getBinaryFromDecimal(int num, int bits) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }
        ArrayList<Integer> binList = new ArrayList<>();
        int remainder;
        while (num != 0) {
            remainder = num % 2;
            binList.add(remainder);
            num /= 2;
        }
        int currentLen = binList.size();
        for (int i = currentLen; i < bits; i++) {
            binList.add(0);
        }
        Collections.reverse(binList);
        if (isNegative)
            getTwosComplement(binList);
        String binaryNum = "";
        for (int digit : binList) {
            binaryNum += digit;
        }
        return binaryNum;
    }

    public static ArrayList<Integer> getTwosComplement(ArrayList<Integer> list) {
        int len = list.size();
        boolean foundOne = false;
        for (int i = len - 1; i >= 0; i--) {
            if (foundOne)
                list.set(i, 1 - list.get(i));
            if (list.get(i) == 1) {
                foundOne = true;
            }
        }
        return list;
    }
}
