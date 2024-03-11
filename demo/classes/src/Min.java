public class Min {
    public static int min(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (result > nums[i])
                result = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -1, -10, 2};
        System.out.println("Least number is: " + Min.min(nums));
    }
}
