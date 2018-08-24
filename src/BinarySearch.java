/**
 * Implementation of BinarySearch
 */
public class BinarySearch {
    /**
     *
     * @param nums - input array to check if it is sorted or not
     * @return - true if sorted, false otherwise
     */
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }

    /**
     *
     * @param nums - input array to find the key in
     * @param key - key to find
     * @return - index of 'key' item, -1 otherwise
     */
    public int indexOf(int[] nums, int key) {

        // Null checks
        if (nums == null)
            throw new NullPointerException("Input array is Null");

        // Assert to make sure input array is sorted
        if (!isSorted(nums))
            throw new IllegalArgumentException("Input array is not sorted");

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = ((high - low) / 2) + low; // To avoid integer overflow
            if (key < nums[mid])
                high = mid - 1;
            else if (key > nums[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private static void passOrFail(int actual, int expected) {
        if (actual == expected)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }

    // Test client for BinarySearch
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 6, 7, 8}; // even number of elements
        int[] input2 = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // odd number of elements
        int[] input3 = {1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8, 9}; // duplicate keys

        BinarySearch search = new BinarySearch();

        passOrFail(search.indexOf(input1, 4), 3);
        passOrFail(search.indexOf(input1, 5), 4);

        passOrFail(search.indexOf(input2, 5), 4);
        passOrFail(search.indexOf(input2, 1), 0);
        passOrFail(search.indexOf(input2, 9), 8);
        passOrFail(search.indexOf(input2, 0), -1);

        passOrFail(search.indexOf(input3, 3), 2);
        passOrFail(search.indexOf(input3, 3), 2);
        passOrFail(search.indexOf(input3, 6), 10);
        passOrFail(search.indexOf(input3, 6), 10);
        passOrFail(search.indexOf(input3, 6), 10);
    }
}
