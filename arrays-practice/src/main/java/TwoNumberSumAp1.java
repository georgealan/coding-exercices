import java.util.*;
import java.util.function.Consumer;

public class TwoNumberSumAp1 {
    static int[] inputNumbers = new int[8];
    static int targetSum;
    static int currentSum;
    static int left;
    static int right;
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a number for targetSum: ");
        targetSum = scanner.nextInt();

        int[] targetResult = createResultOfTargetSum(targetSum);
        int[] arrayFilled = populateInputArray(targetResult);
        int[] result = twoNumberSum(arrayFilled, targetSum);

        /*if (Arrays.toString(targetResult).equals(Arrays.toString(result))) {
            String txt = printResult(targetResult, arrayFilled);
            System.out.println(txt);
        }*/
        System.out.println(Arrays.toString(targetResult));
        System.out.println(Arrays.toString(arrayFilled));
        System.out.println(Arrays.toString(result));

        String txt = printResult(arrayFilled, result);
        System.out.println(txt);
    }

    static String printResult(int[] arrayInputNumbers, int[] resultTargetSum) {
        return "The array: " + Arrays.toString(arrayInputNumbers) + " has these two numbers: " + Arrays.toString(resultTargetSum) + " Wich when sum up will result in: " + targetSum;
    }

    static int[] createResultOfTargetSum(int number) {
        int minus = random.nextInt(1, number);
        int result = number - minus;

        return new int[]{result, minus};
    }

    static int[] populateInputArray(int[] array) {
        Collection<Integer> numbers = new HashSet<>();
        array = sortArray(array);
        int interval = array[1] - array[0];
        int min = array[0] - interval;
        int max = array[1] + interval;
        int number;
        int i = 0;
        numbers.add(array[0]);
        numbers.add(array[1]);

        while (numbers.size() < 8) {
            number = random.nextInt(min, max);
            numbers.add(number);
        }

        for (Integer n : numbers) {
            inputNumbers[i] = n;
            i++;
        }

        return inputNumbers;
    }

    static int[] twoNumberSum(int[] inputNumbers, int targetSum) {
        inputNumbers = Arrays.stream(inputNumbers).sorted().toArray();
        int[] resultSum = new int[2];
        left = 0;
        right = inputNumbers.length -1;

        while (left < right) {
            currentSum = inputNumbers[left] + inputNumbers[right];
            if (currentSum == targetSum) {
                resultSum = new int[]{inputNumbers[left], inputNumbers[right]};
                break;
            } else if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            }
        }

        return resultSum;
    }

    static int[] sortArray(int[] inputNumbers) {
        return Arrays.stream(inputNumbers).sorted().toArray();
    }
}

/*
TODO
 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
 If any two numbers in the input array sum up to the target sum, the function should return them in an array,
 in sorted order. If no two numbers sum up to the target sum, the function should return an empty array.
 Assume that there will be at most one pair of numbers summing up to the target sum.
 */
