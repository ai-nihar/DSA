/**
 * LeetCode ID: 724
 * Title     : Find Pivot Index
 * Difficulty: Easy
 * Language  : Java
 * Author    : Nihar Kakani
 * Date      : 2025-10-30
 *
 * Approach:
 *   - Sum all elements to get total.
 *   - Iterate and maintain leftSum. If leftSum == total - leftSum - nums[i], return i.
 * Complexity:
 *   - Time: O(n)
 *   - Space: O(1)
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int total = 0;
        for (int v : nums) total += v;

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == total - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
