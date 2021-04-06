package miscellaneous;

public class Diamond {
    public static void main(String[] args) {
        printDiamond(10);
    }

    public static void printDiamond(int n){ // 7
        int midIndex = (n % 2 == 1) ? n / 2 : n / 2 - 1; // 3
        int maxLength = midIndex * 2 + 1; // 7

        for (int i = 0; i < n; i++) { // i = 3
            int starSize;
            if (i < n / 2)
                starSize = 1 + (i * 2); //7
            else
                starSize = 1 + ((n - i - 1) * 2); //

            int startStarIndex = (maxLength / 2) - (starSize / 2); //  aa***aa, 2
            int endStarIndex = startStarIndex + starSize; // 5
            for (int j = 0; j < maxLength; j++) {
                if (j >= startStarIndex && j < endStarIndex)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }
}
