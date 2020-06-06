# CP Trials

This repository contains my submitted solutions for various competitive programming challenges.
I've added the page link along with the solution in some classes.
I mostly code in Java here but some of the solutions are there in Kotlin as well.

Also, there would be some test cases written for respective Java and Kotlin solutions.
Happy Coding, Enjoy.

Note: Initially this whole directory was part of a private repo. When I moved the directory to this public repo, I've tried my best to remove all codewars' solutions.
But there might be some here or there. Apologies for that.


### Profiles' Link

![Codewars](https://www.codewars.com/users/Shashi-Bhushan/badges/large)

### Algorithms
Collections of few good problem solving algorithms I have learned over time.

- **Kadane’s algorithm**
*Maximum sum subarray problem*
- Finding the maximum sum of a contiguous subsequence in an array.
Solution available [here](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/search/MaximumSumSubarray.javaa)


- **Binary Tree Traversal**
Unlike arrays and linked list, Tree is not a linear data structure. We could traverse a *Binary* tree in multiple ways.
For  a better explaination on the topic, see [this video](https://www.youtube.com/watch?v=9RHO6jU--GU).
Two broad strategies for traversing a tree are
*Breadth first traversal*
In this traversal, we start from the root level node i.e. the node at the top and traverse the tree one level at a time.
*Depth first traversal*
The main difference here is we would visit all the children of a node before moving on to the next node the same level. If from the root node, I'm going to the left child, I should finish traversing all the nodes at left (the whole subtree) before I could move to the right node.

- **Bit Mask**
[Codeforces blog](https://codeforces.com/blog/entry/18169)

Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand. Check [here](Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand. Check [here](https://www.geeksforgeeks.org/expression-tree/) for examples.
Also, worth noting is post-order is widely use in mathematical expression. This means is, keep the string representation of the expression in postfix notation.
Then, when creating the tree structure, add to stack if character and remove last two element from stack if it's an operator. See implementation [here](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/kotlin/in/shabhushan/cp_trials/tree/expressionTree.kt)

Also read, [Backtracking](src/main/kotlin/in/shabhushan/cp_trials/dsbook/methods/backtracking/README.md)

### Problems Worth Checking

------------------------------

#### Leetcode and Codewars Solutions

I try to keep a list of problems that teach some new way of looking at a potential problem.
The idea here is to keep repeating these questions every now and then until you know the pattern like the back of your hand.
Phased repetition is the key.

- [Pawn Move Tracker](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/string/logic/PawnMoveTracker.java)
- [Path Finder](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dsbook/methods/backtracking/PathFinder.java)
- [Max Sum sub-array](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/MaxSumSubarray.java)
- [Sum of Intervals](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/SumofIntervals.java)
- [Bird Mountain](https://codewars.com/kata/5c09ccc9b48e912946000157/solutions/java/all/best_practice)
- [Product Except Self](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/fundamental/ProductExceptSelf.java)
- [Lexicographically Smaller number](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/fundamental/NextSmaller.java)
- [Lexicographically Larger number](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/fundamental/NextBigger.java)
- [Valid Parentheses](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/string/ValidParentheses.java)
- [Proper Fraction](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/ProperFractions.java)
- [Count Islands](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dsbook/methods/dfs/CountIslands.java)
- [BinarySearch over sorted circular array](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dsbook/methods/search/BinarySearch.java)
- [MinFrogs](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/contest/Weekly185.java#minNumberOfFrogs)
- [Tree Common Parent](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/tree/CommonParent.java)
- [Playing Cards](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/string/logic/PlayingCards.java)
- [Ten Pin Bowling](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/TenPinBowling.java)
- [Matrix Determinant](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/algebra/Matrix.java)
- [Tail Recursive Fibonacci](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/fundamental/Fibonacci.java)
- [Count Sum Squares](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/algebra/SumOfSquares.java)
- [MaxScore](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/contest/Weekly186.java)
- [Longest Sub-array](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/contest/Weekly187.java)
- [Find the Judge(Similar to celebrity problem)](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/logic/CelebrityProblem.java)
- [Single Element in Sorted Array](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/SingleElementInSortedArray.java)
- [Daily Temperature(Stack Solution)](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/DailyTemperature.java)
- [Find Peak](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/binarySearch/FindPeakElement.java)
- [Remove K Digits](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/stack/RemoveKDigits.java)
- [Trie DS](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/tree/Trie.java)
- [Primality Check](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/search/PrimeNumberCheck.java)
- [Kth largest(Using Partition)](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/search/KthLargestElement.java)
- [Maximum Sum subarray](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/search/MaximumSumSubarray.java)
- [Palindrome Path(problem 3 in Set)](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/competition/leetcode/Weekly190.java)
- [Place 2 queen in n positions](https://codereview.stackexchange.com/questions/152545/2-queens-on-n-x-n-board) Also check Section 3.2.2 in CSES book
- [Count Square Submatrix](https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space))


### Useful Algos

-----------------

#### Arrays
- [Contiguous Array](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/array/ContiguousArray.java)
- [Array Sum Target](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/array/ArraySumTarget.java)
- [Bipartition](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/array/Bipartition.java)
- [Queue Reconstruction](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/array/QueueReconstruction.java)

#### Binary Search
- [Probabilities](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/binarySearch/Probabilities.java)

#### Linked List
- [Linked List Deep copy](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/linked_list/CopyRandomDoubleList.java)

#### Tree
- [Count Smaller Element](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/tree/CountSmallerThan.java)

#### Sweep Line
- [Sweep Line](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/sweepline/RightInterval.java)
- [Course Schedule](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/sweepline/CourseSchedule.java)
- [Tasks and Deadline - Section 4.2.3 in CSES Book]

#### Prefix Sum
- [Range Sum](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/prefix_sum/NumArray.java)
- [Composite Sum](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/prefix_sum/CompositeNumbersSum.java)

#### Partition Search
- [Kth largest(Using Partition)](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/search/KthLargestElement.java)

#### Backtracking
- [Backtracking](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/backtracking/README.md)

#### DFS


#### Bit Manipulation
- [Gray Code to Binary](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/fundamental/MysteryFunction.java)
- [Bit Ones Count](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/bits/CountBits.java)
- [Bit Ones in Range](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/math/logic/BitCount.java)

#### Graph
- [Course Schedule 1](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dfs/CourseSchedule.java)
- [Course Schedule 4](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/graph/CourseScheduleIV.java)
- [Min Reorder](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/graph/MinimumReorder.java)

#### Dynamic Programming
- [Coin Change](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dynamic_programming/CoinChange.java)
- [Edit Distance](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dynamic_programming/EditDistance.java)
- [Subsequence](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dynamic_programming/Subsequence.java)
- [House Robber](https://github.com/Shashi-Bhushan/trials/blob/master/cp-trials/src/main/java/in/shabhushan/cp_trials/dynamic_programming/HouseRobber.java)

