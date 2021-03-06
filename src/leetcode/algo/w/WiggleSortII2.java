package leetcode.algo.w;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
// O(nlogn)
public class WiggleSortII2 {

    public static void wiggleSort(int[] nums) {
        int newNum[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNum);
        List<Integer> left = new LinkedList<>(), right = new LinkedList<>();

        for (int i = 0; i < (newNum.length + 1) / 2; i++) {
            left.add(newNum[i]);
        }
        for (int i = (newNum.length + 1) / 2; i < newNum.length; i++) {
            right.add(newNum[i]);
        }

        int p1 = 0, p2 = 0;
        for (int i = newNum.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                nums[i] = left.get(p1++);
            } else {
                nums[i] = right.get(p2++);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
//        int[] nums = {1, 3, 2, 2, 3, 1};
        wiggleSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
