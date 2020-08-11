#include <iostream>
#include <string>
using namespace std;


void getLps(string pattern, int *lps) {
	int size = pattern.size();

	lps[0] = 0;

	int i = 1;
	int val = 0;
	while (i < size) {
		if (pattern[i] == pattern[val]) {
			val++;
			lps[i] = val;
			i++;
		} else {
			if (val != 0) {
				val = lps[val - 1];
			} else {
				lps[i] = 0;
				i++;
			}
		}
	}
}

bool kmp(string str, string pattern) {
	// create Longest prefix suffix (LPS) table for the pattern
	int lps[pattern.size()];
	getLps(pattern, lps);

	for (int i = 0; i < pattern.size(); i++) {
		cout << lps[i] << " ";
	}
	cout << endl;

	return false;
}

int main(int argc, char *argv[]) {
	string str;
	cout << "Enter the String" << endl;
	cin >> str;

	string pattern;
	cout << "Enter the pattern" << endl;
	cin >> pattern;

	bool result = kmp(str, pattern);
	cout << "Does the word \"" << pattern << "\" is within \"" << str << "\" : " << result << endl;
	return 0;
}
