package enosis;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
//        String reversed = reverseString("");
//        System.out.println(reversed);
//        System.out.println(reverseSentenceV2("I am a cow"));
//        printMultipleOf3();
        printSequence();
    }

    static String reverseString(String str) {
        int len = str.length();
        char[] reversed = str.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char temp = reversed[i];
            reversed[i] = reversed[len - i - 1];
            reversed[len - i - 1] = temp;
        }
        return String.valueOf(reversed);
    }

    static String reverseSentence(String sentence) {
        String word[] = sentence.split(" ");
        int len = word.length;
        StringBuilder reversedSentence = new StringBuilder();
        reversedSentence.append(word[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            reversedSentence.append(' ');
            reversedSentence.append(word[i]);
        }
        return reversedSentence.toString();
    }

    static String reverseSentenceV2(String sentence) {
        int len = sentence.length();
        Stack<String> wordStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char currentChar = sentence.charAt(i);
            if (currentChar == ' ') {
                wordStack.add(builder.toString());
                builder.setLength(0);
            }
            else {
                builder.append(currentChar);
            }
        }
        wordStack.add(builder.toString());
        builder.setLength(0);
        builder.append(wordStack.pop());
        while (!wordStack.isEmpty()) {
            builder.append(' ');
            builder.append(wordStack.pop());
        }
        return builder.toString();
    }

    static void printMultipleOf3() {
        for (int i = 198; i > 1; i -= 3)
            System.out.print(i + " ");
    }

    static void printSequence() {
        for (int i = 0; i < 19; i++) {
            if (i < 10)
                System.out.print(10 - i + " ");
            else
                System.out.print(i - 8 + " ");
        }
    }
}
