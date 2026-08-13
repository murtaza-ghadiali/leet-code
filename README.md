# LeetCode Java Solutions

This repository contains Java solutions to various LeetCode problems. Each solution is designed to be clear, efficient, and easy to follow, with a focus on correctness and interview-style reasoning.

## Purpose

The goal of this repo is to:

- practice solving LeetCode problems in Java
- improve problem-solving and coding consistency
- document approaches and complexity for each solution
- build a reusable reference for future interview preparation

## Repository Structure

Each problem will be stored in its own folder, with a dedicated README and Java solution. This makes it easier to study one problem at a time and keep the explanation, approach, and code together.

```text
leet-code/
├── README.md
├── 1-two-sum/
│   ├── README.md
│   └── Solution.java
├── 3-longest-substring-without-repeating-characters/
│   ├── README.md
│   └── Solution.java
├── 4-median-of-two-sorted-arrays/
│   ├── README.md
│   └── Solution.java
├── 15-3sum/
│   ├── README.md
│   └── Solution.java
└── ...
```

This structure is more practical for LeetCode practice because every problem folder contains its own problem summary, explanation, and implementation.

## Solution Format

Each Java file usually includes:

- problem statement summary
- class name matching the problem
- approach explanation in comments or docs
- time complexity
- space complexity
- main method or method implementation used by LeetCode

Example:

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
```

## How to Run Java Solutions

Make sure Java is installed on your machine.

Check version:

```bash
java -version
javac -version
```

Compile a solution:

```bash
javac TwoSum.java
```

Run it:

```bash
java TwoSum
```

If the file belongs to a package, use the correct package path and compile from the project root.

## Recommended Practices

- use descriptive class names
- keep code readable and concise
- include comments for logic and edge cases
- mention time and space complexity in each solution
- test against sample inputs before finalizing

## Contribution Style

When adding a new solution:

1. choose the problem name and number
2. create a Java file with a matching class name
3. include the algorithm explanation
4. validate with sample test cases
5. update this README if the repo structure changes

## Notes

This repository is intended for learning, practicing, and improving Java problem-solving skills for coding interviews and algorithmic challenges.

## License

This project is for personal learning and practice. Add a license if you plan to share it publicly.
