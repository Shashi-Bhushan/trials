#include <algorithm>
#include <bitset>
#include <cassert>
#include <chrono>
#include <cstring>
#include <iomanip>
#include <iostream>
#include <map>
#include <queue>
#include <random>
#include <set>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// BEGIN NO SAD
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define f first
#define s second

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

vector<string> strings;

// backtrack and Add one character to temp String in each recursion
// at the end, add the whole string to "strings" if all the characters in freq has been used
// NOTE: Since we need the size to be printed first, hence saving this in vector. Otherwise I would simply print it
void printPerm(int *freq, string s) {
	bool print = true;

	for (int i = 0; i < 26; i++) {
		if (freq[i] != 0) {
			freq[i]--;
			char x = 'a' + i;
			printPerm(freq, s + x);
			freq[i]++;

			print = false;
		}
	}

	if (print) {
		strings.push_back(s);
	}
}

void solve() {
	string s;
	cin >> s;

	int freq[26];

	for (int i = 0; i < 26; i++) {
		freq[i] = 0;
	}

	for (char c: s) {
		freq[c - 'a']++;
	}


	printPerm(freq, "");

	cout << strings.size() << endl;
	for (string str: strings) {
		cout << str << endl;
	}
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	solve();

	return 0;
}
