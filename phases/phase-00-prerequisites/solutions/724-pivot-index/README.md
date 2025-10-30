# 1480 — Running Sum of 1d Array

**Platform:** LeetCode  
**Difficulty:** Easy

## Problem link
https://leetcode.com/problems/running-sum-of-1d-array/

## Approach
Modify the input array in-place by converting it to prefix sums:
- For each index `i` from `1` to `n-1`, set `nums[i] += nums[i-1]`.

This yields `nums[i] = sum(nums[0..i])`.

## Complexity
- Time: O(n)
- Space: O(1) extra (in-place)

## Edge cases
- Empty array → return empty
- Single element → return same element