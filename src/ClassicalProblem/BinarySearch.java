package ClassicalProblem;

public class BinarySearch {

    /**
     * @param nums
     * @param target
     * @return The first position of target.
     */
    static public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5, 8, 10, 324, 2344};
        System.out.println(binarySearch(array, 8));
    }

}
