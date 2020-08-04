/*
 * Reverse a String

 Sample Input 1:
 Welcome to Coding Ninjas
 Sample Output 1:
 Ninjas Coding to Welcome

 Sample Input 2:
 Always indent your code
 Sample Output 2:
 code your indent Always

 */

void reverse(char input[], int start, int end) {
    while (start < end) {
        std::swap(input[start++], input[end--]);
    }

}

void reverseStringWordWise(char input[]) {
    int i = 0;

    int prevSpace = -1;

    while (input[i] != '\0') {
        if (input[i] == ' ') {
            reverse(input, prevSpace + 1, i - 1);
            prevSpace = i;
        }
        i++;
    }

    reverse(input, prevSpace + 1, i - 1);
    reverse(input, 0, i - 1);
}
