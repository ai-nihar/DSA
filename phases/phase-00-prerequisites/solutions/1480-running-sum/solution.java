/**
 * Problem    : 1480 — Running Sum of 1d Array
 * Difficulty : Easy
 * Language   : Java
 * Author     : Nihar Kakani
 * Date       : 2025-10-30
 *
 * Summary:
 *   Compute in-place prefix sums so each index i holds the sum of nums[0..i].
 *
 * Approach:
 *   - Iterate i from 1..n-1 and add the previous prefix to current: nums[i] += nums[i-1].
 *
 * Complexity:
 *   - Time  : O(n)
 *   - Space : O(1) extra
 */

class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}