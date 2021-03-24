package hackerrank;

import test.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class General {
    public static void main(String[] args) {
//        substrCount(7, "abcbaba");
//        flippingBits(8);
//        2 1
//        10 7
//        9 5
//        6 9
//        7 3
        List<List<Long>> sides = List.of(
                List.of(2l, 1l),
                List.of(10l, 7l),
                List.of(9l, 5l),
                List.of(6l, 9l),
                List.of(7l, 3l)
        );
        nearlySimilarRectangles(sides);
    }

    public static long nearlySimilarRectangles(List<List<Long>> sides) {
        // Write your code here
        Map<Double, Integer> countMap = new HashMap<>();
        for (List<Long> side : sides) {
            double ratio = side.get(0) / side.get(1);
            Test.printStuffs(side.get(0), side.get(1), ratio);
            Integer count = countMap.get(ratio);
            if (count == null)
                countMap.put(ratio, 1);
            else
                countMap.put(ratio, count + 1);
        }
        long  similarCount = 0;
        for (long val : countMap.values()) {
            System.out.println(val);
            long combination = (val * (val - 1)) / 2;
            similarCount += combination;
        }
        return similarCount;
    }

    static long flippingBits(long n) {
        String binary = getBinaryString(n);
        int len = binary.length();
        char[] binaryArray = new char[32];
        for (int i = 0; i < 32 - len; i++)
            binaryArray[i] = '1';
        for (int i = 0; i < len; i++) {
            char newChar = (char) ('1' - binary.charAt(i) + '0');
            binaryArray[32 - len + i] = newChar;
        }
        System.out.println(binary);
        System.out.println(binaryArray);
        long newNum = 0, base = 1;
        for (int i = 31; i >=0; i--) {
            newNum += ((binaryArray[i] - '0') * base);
            base *= 2;
        }
        System.out.println(newNum);
        return newNum;
    }

    static String getBinaryString(long n) {
        if (n == 0)
            return "";
        String remaining = String.valueOf(n % 2);
        n = n / 2;
        return getBinaryString(n) + remaining;
    }

    static long substrCount(int n, String s) {
        long specialCount = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                String subString = s.substring(j, j + i);
                if (isSpecial(subString)) {
                    specialCount++;
                    System.out.println(subString);
                }
            }
        }
        return specialCount;
    }

    static boolean isSpecial(String s) {
        int len = s.length();
        int firstChar = s.charAt(0);
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
            if (s.charAt(i) != firstChar)
                return false;
        }
        return true;
    }

}
