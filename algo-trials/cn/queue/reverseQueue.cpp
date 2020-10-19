#include<queue>
#include<stack>

/**
 * Reverse a queue using recursion
 */
void reverseQueue(queue<int> &input) {
    if (input.size() > 1) {
        // Write your code here
        int front = input.front();
        input.pop();

        reverseQueue(input);

        input.push(front);
    }
}
