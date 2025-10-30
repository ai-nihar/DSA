# 1480. Running Sum of 1d Array

## Problem

Given an integer array nums, return the running sum of nums. The running sum at index i is the sum of elements from index 0 to i, inclusive.

## Approach

- Iterate once from left to right, accumulating the sum in-place: nums[i] += nums[i - 1].
- This uses O(1) extra space and updates the array as we go.

## Complexity

- Time: O(n)
- Space: O(1) in-place

## Notes
- In-place modification is acceptable for this problem; if not allowed, maintain a separate prefix sum variable and write to a new array.
- Edge cases: empty array (returns empty), single element (unchanged).

## References
- Original problem: https://leetcode.com/problems/running-sum-of-1d-array/
