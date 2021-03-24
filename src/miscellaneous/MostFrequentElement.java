package miscellaneous;

import sorting.MergeSort;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public static void main(String[] args) {
        int[] array = {13, 1, 2, 13, 8, -2, 10, 8, 8, 2, 10, 13, 7, 6, 13};
        System.out.println(getMostFrequentElementV1(array));
    }

    public static int getMostFrequentElementV1(int[] array){
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int val : array){
            Integer count = countMap.get(val);
            countMap.put(val, (count != null) ? count + 1 : 1);
        }
        System.out.println(countMap.toString());
        int maxCount = 1;
        int maxOccurredValue = array[0];
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxOccurredValue = entry.getKey();
            }
        }
        return maxOccurredValue;
    }

    public static int getMostFrequentElementV2(int[] array){
        MergeSort.mergeSort(array);
        int len = array.length;
        int maxCount = 1, count = 1;
        int maxOccurredValue = array[0];
        for(int i = 1; i < len; i++){
            if(array[i] == array[i-1])
                count++;
            else{
                if(count > maxCount){
                    maxCount = count;
                    maxOccurredValue = array[i - 1];
                }
                count = 1;
            }
        }
        if(count > maxCount){
            maxCount = count;
            maxOccurredValue = array[len - 1];
        }
//        System.out.println(maxCount);
        return maxOccurredValue;
    }
}
