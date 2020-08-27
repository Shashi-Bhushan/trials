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

void solve() {
	string s;
	cin >> s;

	// Add a $ at the end
	s += "$";
	int n = s.size();

	// p => position
	// c => classes
	vi p(n), c(n);
	{
		// k = 0
		// Character to index
		vector<pair<char, int>> a(n);

		// Step 1: Assign index
		for (int i = 0; i < n; i++) {
			a[i] = {s[i], i};
		}

		// Step 2: Sort
		sort(a.begin(), a.end());

		for (int i = 0; i < n; i++) {
			p[i] = a[i].second;
		}

		// Step 3: Assign classes
		c[p[0]] = 0;
		for (int i = 1; i < n; i++) {
			// If two `characters` are same, assign same class, else assign a difference class
			if (a[i].first == a[i - 1].first) {
				c[p[i]] = c[p[i - 1]];
			} else {
				c[p[i]] = c[p[i - 1]] + 1;
			}
		}
	}

	// current phase
	int k = 0;

	// Keep increasing k by 2
	while ((1 << k) < n) {
		// transition from K -> k + 1
		
		// Map<pair of previous equivalence classes, position>
		vector<pair<pii, int>> a(n);

		for (int i = 0; i < n; i++) {
			a[i] = {
				{c[i], c[(i + (1 << k)) % n]},
				i
			};
		}

		sort(a.begin(), a.end());

		for (int i = 0; i < n; i++) {
			p[i] = a[i].second;
		}

		for (int i = 1; i < n; i++) {
			// If two `pairs` are same, assign same class, else assign a difference class
			if (a[i].first == a[i - 1].first) {
				c[p[i]] = c[p[i - 1]];
			} else {
				c[p[i]] = c[p[i - 1]] + 1;
			}
		}

		k++;
	}

	// print final suffix array
	for (int i = 0; i < n; i++) {
		cout << p[i] << " " << s.substr(p[i], n - p[i]) << endl;
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
