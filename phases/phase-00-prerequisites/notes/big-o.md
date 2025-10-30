# Big-O Notes (Quick Reference)

---
### What it measures
- **Time complexity:** how runtime grows with input size `n`.
- **Space complexity:** how extra memory grows with `n`.

---
### Common notations (fast → slow)
- `O(1)` — constant time (array access)
- `O(log n)` — logarithmic (binary search)
- `O(n)` — linear (single loop)
- `O(n log n)` — mergesort/quicksort average
- `O(n^2)` — nested loops (bubble sort)
- `O(2^n)` — exponential (subset enumeration)
- `O(n!)` — factorial (permutations)

---
### Tips
- Nested loops often lead to multiplicative complexities.
- Recurrences: T(n) = 2T(n/2) + O(n) → O(n log n).
- Always consider worst-case unless stated otherwise.
- Space: count only extra space (ignore input).

### Example
Single loop:
```java
for(int i=0; i<n; i++) // O(n)
