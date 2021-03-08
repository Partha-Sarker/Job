package miscellaneous;

import test.Test;

public class LargestNumbers {
    public static void main(String[] args) {
        int[] array = {1, 2, 8, -2, 10, 8, 8, 2, 10, 13, 7, 6, 13};
        int[] smallArray = {1, 1};
        getSecondLargestByValue(array);
    }

    public static int getLargestNumber(int[] array){
        int largestNumber = Integer.MIN_VALUE;
        for(int num : array){
            if(num > largestNumber)
                largestNumber = num;
        }
        System.out.println(largestNumber);
        return largestNumber;
    }

    public static int getSecondLargestNumberByIndex(int[] array){
        int largest, secondLargest;
        if(array[0] > array[1]){
            largest = array[0];
            secondLargest = array[1];
        }
        else{
            largest = array[1];
            secondLargest = array[0];
        }
        int len = array.length;
        for(int i = 2; i < len; i++){
            if(array[i] >= largest){
                secondLargest = largest;
                largest = array[i];
            }
        }
        Test.printStuffs(largest, secondLargest);
        return secondLargest;
    }

    public static int getSecondLargestByValue(int[] array){
        int largest = array[0], secondLargest = -1;
        int len = array.length;
        for(int i = 1; i < len; i++){
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            }
        }
        Test.printStuffs(largest, secondLargest);
        return secondLargest;
    }
}
