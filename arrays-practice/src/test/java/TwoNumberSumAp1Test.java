import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * TODO
 *  Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
 *  If any two numbers in the input array sum up to the target sum, the function should return them in an array,
 *  in sorted order. If no two numbers sum up to the target sum, the function should return an empty array.
 *  Assume that there will be at most one pair of numbers summing up to the target sum.
 *
 *  Result has to be: [-1, 11]
 */
class TwoNumberSumAp1Test {

    private TwoNumberSumAp1 twoNumberSumAp1;
    private int[] inputNumbers;
    private int targetSum;

    @BeforeEach
    void init() {
        twoNumberSumAp1 = new TwoNumberSumAp1();
        inputNumbers = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        targetSum = 10;
    }

    @Test
    @DisplayName("Should return an non-empty array")
    public void firstTest() {
        int[] result = twoNumberSumAp1.twoNumberSum(inputNumbers, targetSum);
        assertThat(result).contains(3, 5, -4, 8, 11, 1, -1, 6);
    }

    /*@Disabled
    @Test
    @DisplayName("Must be return the array sorted in increasing order")
    public void arrayMustBeSortedInIncreasingOrder() {
        int[] result = twoNumberSumAp1.sortArray(inputNumbers);
        assertThat(result).contains(-4, -1, 1, 3, 5, 6, 8, 11);
    }*/
}
