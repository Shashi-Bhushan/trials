# Backtracking

Backtracking is a method to solve the problems by making **a series of choices** that we can *return or backtrack* to.
The call stack remembers our choices and knows what to choose.
Backtracking is brute force method with an optimization. We take the choice that seems most logical at the moment and move forward from there.
But if at any point, we don't have any choice to move forward with, we track back to the most recent choice selection (using stack) and make the second choice.
In the worst case, it will also end up exhaustively searching like bruteforce method.

There are 3 key concepts here. Let us understand it with the example of N queen problem.

### 1. Our Choice

What choice do we make at each call of the function ?
Here *recursion expressed <u>decision</u>*.
In N queen problem, we choose to place the queen at a certain block. We undo our choice if it doesn't pan out and move to the next choice.

### 2. Our constraint

When do we stop following a certain path ?
When do we discard a certain path altogether ?

The constraint we have is checked by #isValidPlacement() function call.
If this is invalid placement, or if we are not able to solve N queen problem with this placement, we will try with the next cell placement.

### 3. Our Goal

What are we trying to achieve ?
Note that this defines our base case.

The goal that we are trying to achieve with N queen problem is to be able to reach the end row. This would signify that we have placed all the queens successfully, thus solving the problem.

## Problems to Solve

1. [Subsets](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/)
2. [Letter Tile possibilities](https://leetcode.com/problems/letter-tile-possibilities/)
