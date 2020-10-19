#include<stack>

/*
 * Check if there are any redundant brackets in a given expression
 * try it for inputs
 * a -> false
 * (a) -> true
 * (a + b) -> false
 * (a + b) + (c + d) -> false
 * (a + b) + (c + (d)) -> true
 */
bool checkRedundantBrackets(string expression) {
    stack<int> st;

	// Write your code here
    for (char c: expression) {
        if (c == '(') {
            st.push(0);
        } else if (c == ')') {
            int c = st.top();
            st.pop();

            if (c == 0) return true;
        } else if (c == '+' || c == '-' || c == '/' || c == '*') {
            if (!st.empty()) {
                // increment last element in stack
                int t = st.top();
                st.pop();
                st.push(t + 1);
            }
        }
    }

    return false;
}
