package string;

public class Main {

    public static void main(String[] args) {
//        System.out.println(checkAnagram("nl", "cx"));
//        System.out.println('z' - 'a' + 1);
//        reverseStringV1("dhfjdhj");
//        System.out.println(Integer.valueOf("1010", 2));
    }

    public static String reverseString(String str){
        int len = str.length();
        char[] charStr = new char[len];
        for(int i = 0; i < len; i++){
            charStr[len - i - 1] = str.charAt(i);
        }
        return String.copyValueOf(charStr);
    }

    public static boolean isStringInsideString(String bigString, String smallString){
        int bigLen = bigString.length(), smallLen = smallString.length();
        if(bigLen < smallLen)
            return false;
        for(int i = 0; i < bigLen - smallLen + 1; i++){
            int matchCount = 0;
            for(int j = 0; j < smallLen; j++){
                if(smallString.charAt(j) == bigString.charAt(i + j))
                    matchCount++;
                else
                    break;
            }
            if(matchCount == smallLen)
                return true;
        }
        return false;
    }

    public static int getSubStringPos(String bigString, String smallString){
        int bigLen = bigString.length(), smallLen = smallString.length();
        if(bigLen < smallLen)
            return -1;
        for(int i = 0; i < bigLen - smallLen + 1; i++){
            int matchCount = 0;
            for(int j = 0; j < smallLen; j++){
                if(smallString.charAt(j) == bigString.charAt(i + j))
                    matchCount++;
                else
                    break;
            }
            if(matchCount == smallLen)
                return i;
        }
        return -1;
    }

    public static String removeSubStringFromStringV1(String originalString, String subString){
        int subStringPos = getSubStringPos(originalString, subString);
        System.out.println(subStringPos);
        if(subStringPos == -1)
            return originalString;
        int subStringLen = subString.length();
        String startString = originalString.substring(0, subStringPos);
        String endString = originalString.substring(subStringPos + subStringLen);
        originalString = startString + endString;
        return originalString;
    }

    public static String removeSubStringFromStringV2(String originalString, String subString){ //hello
        int subStringPos = getSubStringPos(originalString, subString);
        System.out.println(subStringPos);
        if(subStringPos == -1)
            return originalString;
        int origLen = originalString.length(), subLen = subString.length();
        char[] newCharString = new char[origLen - subLen];
        for(int i = 0; i < origLen - subLen; i++){
            if(i >= subStringPos)
                newCharString[i] = originalString.charAt(i + subLen);
            else
                newCharString[i] = originalString.charAt(i);
        }
        return String.valueOf(newCharString);
    }

    public static String changeFirstCharOfWordToLower(String str) {
        char[] strArray = str.toCharArray();
        int len = strArray.length;
        int diff = 'A' - 'a';
        for (int i = 0; i < len - 1; i++) {
            if (i == 0 && (strArray[i] >= 'A' && strArray[i] <= 'Z')) {
                strArray[i] -= diff;
            }
            if (strArray[i] == ' ' && (strArray[i + 1] >= 'A' && strArray[i + 1] <= 'Z')) {
                strArray[i + 1] -= diff;
            }
        }
//        return new String(strArray);
//        return strArray.toString();
        return String.valueOf(strArray);
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeLeetCode(String s) {
        int endPointer = s.length() - 1;
        int startPointer = 0;
        int diff = 'a' - 'A';
        while (endPointer > startPointer) {
            char startChar = s.charAt(startPointer);
            if (!isAlphaNumeric(startChar)){
                startPointer++;
                continue;
            }
            char endChar = s.charAt(endPointer);
            if (!isAlphaNumeric(endChar)){
                endPointer--;
                continue;
            }
            if (startChar >= 'A' && startChar <= 'Z')
                startChar += diff;
            if (endChar >= 'A' && endChar <= 'Z')
                endChar += diff;
            if (startChar != endChar)
                return false;
            startPointer++;
            endPointer--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }

    public static int firstNonRepeatingCharactersIndex(String s) {
        int[] countArray = new int['z' - 'a' + 1];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int charIndex = s.charAt(i) - 'a';
            countArray[charIndex]++;
        }
        for (int i = 0; i < len; i++) {
            int charIndex = s.charAt(i) - 'a';
            if(countArray[charIndex] == 1)
                return i;
        }
        return -1;
    }

    public static boolean checkAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2)
            return false;
        int[] countArray = new int['z' - 'a' + 1];
        for (int i = 0; i < len1; i++) {
            countArray[s.charAt(i) - 'a']++;
            countArray[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0)
                return false;
        }
        return true;
    }

    public static String reverseStringV1(String s) {
        StringBuilder sBuilder = new StringBuilder(s);
        return sBuilder.reverse().toString();
    }
}
