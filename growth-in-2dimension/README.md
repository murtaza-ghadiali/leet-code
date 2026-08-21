# 1. Growth in 2 Dimensions

You are working with an infinite 2D grid that starts with all cells set to 0.

The grid is indexed from (1,1) at the bottom-left, with rows increasing upward and columns increasing to the right.

You are given n operations.

For each coordinate pair (r, c):

- Increment every cell in the rectangular region from (1,1) to (r, c) (inclusive) by 1.
- After all operations are applied, your task is to:
- Determine the maximum value present in the grid.
- Return the number of cells that contain this maximum value.

## Example 1

Suppose upRight = ["1 4", "2 3", "4 1"]
Output: 1

There are n = 3 (r, c) pairs, where the space-separated integers within each string represent r and c, respectively. The following diagrams show each iteration starting at zero. The maximal value in the grid is 3, and there is 1 occurrence at cell (1, 1).

### Visual reference

```text
Initial Grid
    4   0  0  0  0
    3   0  0  0  0
    2   0  0  0  0
    1   0  0  0  0
        1  2  3  4

Step 0: r = 1, c = 4
    4   0  0  0  0
    3   0  0  0  0
    2   0  0  0  0
    1   1  1  1  1
        1  2  3  4

Step 1: r = 2, c = 3
    4   0  0  0  0
    3   0  0  0  0
    2   1  1  1  0
    1   1  2  2  1
        1  2  3  4

Step 2: r = 4, c = 1
    4   0  0  0  0
    3   1  0  0  0
    2   2  1  1  0
    1   3  2  2  1
        1  2  3  4
```

The maximum value in the grid is 3, and it appears only once at cell (1,1).

## Example 2

Suppose upRight = ["2 3", "3 7", "4 1"]
Output: 2

There are n = 3 (r, c) pairs. The following diagrams show each operation starting from zero. The maximum value in the grid is 3, and it appears at cells (1, 1) and (2, 1).

### Visual reference

```text
Initial Grid
    4   0  0  0  0  0  0  0
    3   0  0  0  0  0  0  0
    2   0  0  0  0  0  0  0
    1   0  0  0  0  0  0  0
        1  2  3  4  5  6  7

Step 0: r = 2, c = 3
    4   0  0  0  0  0  0  0
    3   0  0  0  0  0  0  0
    2   1  1  1  0  0  0  0
    1   1  1  1  0  0  0  0
        1  2  3  4  5  6  7

Step 1: r = 3, c = 7
    4   0  0  0  0  0  0  0
    3   1  1  1  1  1  1  1
    2   2  2  2  1  1  1  1
    1   2  2  2  1  1  1  1
        1  2  3  4  5  6  7

Step 2: r = 4, c = 1
    4   1  0  0  0  0  0  0
    3   2  1  1  1  1  1  1
    2   3  2  2  1  1  1  1
    1   3  2  2  1  1  1  1
        1  2  3  4  5  6  7
```

The final maximum value is 3, and it occurs at (1,1) and (2,1).

## Constraints

- `1 <= n <= 100`
- `1 <= number of rows, number of columns <= 10^6`

## Approach

The key observation is that each operation adds 1 to every cell in the rectangle from (1,1) to (r,c). This means the final value at cell (i,j) is the number of operations whose rectangle covers that cell.

A coordinate (i,j) is covered by an operation (r,c) exactly when `i <= r` and `j <= c`. So the value at (i,j) is:

`count = number of operations with r >= i and c >= j`

This can be solved efficiently with a difference array or by tracking the maximum rectangle contributions.

### Idea

- For every operation `(r, c)`, increment the point `(r, c)` in a 2D difference array.
- Then accumulate prefix sums to compute how many times each cell is incremented.
- The maximum prefix sum is the maximum value in the grid.
- Count how many cells reach that maximum.

### Complexity

- Time Complexity: `O(n + m)` for the grid processing, where `m` is the number of relevant cells after coordinate compression.
- Space Complexity: `O(m)`
