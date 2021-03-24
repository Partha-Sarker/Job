package enosis;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File newFile = new File("src/miscellaneous/input.txt");
//        try {
//            FileWriter writer = new FileWriter(newFile);
//            writer.write("3 4 1 5 0 4 8 -4 8 -3 19");
//            writer.close();
//        }
//        catch (IOException e) {
//            System.out.println("Error occurred");
//        }
        try {
            Scanner scanner = new Scanner(newFile);
            int sum = 0, count = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                count++;
            }
            System.out.println(String.format("%.2f", (double) sum / (double) count));
        }
        catch (FileNotFoundException e) {

        }
    }
}
