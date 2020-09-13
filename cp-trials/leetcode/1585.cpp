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

class Solution {
public:
	bool isTransformable(string s, string t) {
   	vector<char> a, b;

		for (auto x: s) a.push_back(x);
		for (auto x: t) b.push_back(x);

		// Start from highest character
		for (char ch = '9'; ch >= '0'; ch--) {
			int i = 0;
			int j = 0;

			// remember locations of the current character
			vector<int> aloc, bloc;

			for (int i = 0; i < sz(a); i++) {
				if (a[i] == ch) aloc.push_back(i);
			}

			for (int i = 0; i < sz(b); i++) {
				if (b[i] == ch) bloc.push_back(i);
			}

			// if character count doesn't match in both, then return false
			if (sz(aloc) != sz(bloc)) return false;
			for (int i = 0; i < sz(aloc); i++) {
				// if higher character is on a lesser index in vector b, then an increasing sort can't place this character on it's current location
				// for eg, see s = "34521" and t = "53412" location of 5 is less in t. No solution exists
				if (aloc[i] > bloc[i]) return false;
			}

			// Remove higher characters from evaluation now
			vector<char> na, nb;
			for (auto x: a) if (x < ch) na.push_back(x);
			for (auto x: b) if (x < ch) nb.push_back(x);

			a.swap(na);
			b.swap(nb);
		}

		return true;
  }
};
