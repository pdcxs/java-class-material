import java.util.*;

// https://leetcode.cn/problems/two-sum/description/

/*
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class LeetCodeFirstProblem {
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }

        return result;
    }

    static void printResult(int[] result) {
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static void main(String[] args) {
        printResult(twoSum(new int[]{2, 7, 11, 15}, 9));
        printResult(twoSum(new int[]{3, 2, 4}, 6));
        printResult(twoSum(new int[]{3, 3}, 6));
    }
}
