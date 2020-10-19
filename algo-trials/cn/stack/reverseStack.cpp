/**
 * Reverse a stack using another stack
 */
void reverseStack(stack<int> &input, stack<int> &extra) {
    //Write your code here
    for (int i = 1; i < input.size(); i++) {
        int j = 0;

        while (j < i) {
			extra.push(input.top());
            input.pop();

            j++;
        }

        int tmp = input.top();
        input.pop();

        while (!extra.empty()) {
            input.push(extra.top());
            extra.pop();
        }

        input.push(tmp);
    }
}
