package numbersystem;

import test.Test;

public class ReverseInt {
    public static void main(String[] args) {
//        System.out.println(-Integer.MIN_VALUE);
        System.out.println(reverseV1(-2147483648));
    }

    public static int reverseV1(int x) {
        long currentNum = x;
        boolean isNegative = (currentNum < 0) ? true : false;
        if (isNegative)
            currentNum = -currentNum;

        long reverseNum = 0;
        while (currentNum != 0) {
            long digit = currentNum % 10;
            reverseNum = reverseNum * 10 + digit;
            currentNum /= 10;
            if (reverseNum > Integer.MAX_VALUE)
                return 0;
        }
        if (isNegative) {
            reverseNum = -reverseNum;
            if (reverseNum < Integer.MIN_VALUE)
                return 0;
        }
        System.out.println(reverseNum);
        return (int) reverseNum;
    }

    public static int reverse(int num) {
        boolean negativeFlag = false;
        if (num < 0)
        {
            negativeFlag = true;
            num = -num ;
            System.out.println(num);
        }

        int prev_rev_num = 0, rev_num = 0;
        while (num != 0)
        {
            int curr_digit = num%10;
            rev_num = (rev_num*10) + curr_digit;
            Test.printStuffs(curr_digit, rev_num, prev_rev_num);
            if ((rev_num - curr_digit)/10 != prev_rev_num)
            {
                System.out.println("WARNING OVERFLOWED!!!");
                return 0;
            }
            prev_rev_num = rev_num;
            num = num/10;
        }
        return (negativeFlag == true) ? -rev_num : rev_num;
    }
}
