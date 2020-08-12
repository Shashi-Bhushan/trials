#include <iostream>
#include <string>
using namespace std;


void getLps(string pattern, int *lps) {
	int size = pattern.size();

	// first is always 0
	lps[0] = 0;

	int val = 0;
	// start filling lps from position 1
	int i = 1;

	while (i < size) {
		if (pattern[i] == pattern[val]) {
			val++;
			lps[i] = val;
			i++;
		} else {
			if (val != 0) {
				val = lps[val - 1];
			} else {
				// val is 0
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

	int i = 0; // string index
	int j = 0; // pattern index

	while	(i < str.size()) {
		if (pattern[j] == str[i]) {
			j++;
			i++;
		}
		
		if (j == pattern.size()) {
			cout << "Found pattern from index " << (i - j) << "(inclusive) to index " << i << "(exclusive)." << endl;
			return true;
		}
		else if (i < str.size() && pattern[j] != str[i]) {
			// mismatch after j matches
			if (j == 0) i++;
			else j = lps[j - 1];
		}
	}

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
