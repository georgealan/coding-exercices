import java.util.*;

public class TwoNumberSumAp2 {
    static int targetSum;
    static int operationResult;
    static int[] result = new int[2];
    static Map<Integer, Boolean> numbersPresent = new Hashtable<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a number for targetSum ");
        targetSum = scanner.nextInt();

        int[] targetResult = TwoNumberSumAp1.createResultOfTargetSum(targetSum);
        int[] arrayFilled = TwoNumberSumAp1.populateInputArray(targetResult);
        int[] expectedResult = TwoNumberSumAp1.twoNumberSum(arrayFilled, targetSum);

        checkArrayTwoNumberSum(arrayFilled);

        verifyResult(result, expectedResult);
    }

    private static void checkArrayTwoNumberSum(int[] arrayFilled) {
        for (int currentNum : arrayFilled) {
            operationResult = targetSum - currentNum;
            if (!numbersPresent.containsKey(operationResult)) {
                numbersPresent.put(currentNum, true);
            } else {
                result[0] = operationResult;
                result[1] = currentNum;
            }
        }
    }

    static void verifyResult(int[] x, int[] y) {
        int i = 0;
        String message = "";

        for (int a : x) {
            if (a == y[i]) {
                message = "All results match, you are a champion dude! congrats! see there the algorithm result: "
                        + Arrays.toString(x) + " compared to expected result: " + Arrays.toString(y);
                i++;
            } else {
                message = "Oh No! the algorithm that you wrote is a joke dude! see you pathetic failure here, the result: "
                        + Arrays.toString(x) + " compared to expected result: " + Arrays.toString(y);
                break;
            }
        }
        System.out.println(message);
    }
}


/*
TODO
 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
 If any two numbers in the input array sum up to the target sum, the function should return them in an array,
 in sorted order. If no two numbers sum up to the target sum, the function should return an empty array.
 Assume that there will be at most one pair of numbers summing up to the target sum.
 */
