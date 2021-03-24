package hackerrank;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> countMap = new HashMap<>();
        long tripletCount = 0;

        for (long thirdNum : arr) {
            Long thirdCount = countMap.get(thirdNum);
            if (thirdCount == null)
                countMap.put(thirdNum, 1L);
            else
                countMap.put(thirdNum, thirdCount + 1);

            if (thirdNum % (r * r) != 0)
                continue;

            Long secondCount = countMap.get(thirdNum / r);
            Long firstCount = countMap.get(thirdNum / (r * r));

            if (secondCount == null || firstCount == null)
                continue;
            if (r == 1) {
                secondCount -= 1;
                firstCount -= 2;
            }
            if (secondCount <= 0 || firstCount <= 0)
                continue;
            tripletCount += (secondCount * firstCount);
        }
        return tripletCount;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/hackerrank/test_case.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/output.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
