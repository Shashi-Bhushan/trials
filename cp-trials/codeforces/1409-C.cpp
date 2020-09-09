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

#define REP(i, n) for (int i = 0; i < (n); i++)
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define f first
#define s second

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

const int MOD = 1e9 + 7;

void solve() {
	int n, x, y;

	cin >> n >> x >> y;
	deque<int> dq;

	int diff = y - x;

	// PreRequisite: Find difference `d` of the AP
	int d = 1;
	while (d <= 50) {
		// i is divisor and largest `diff/d` smaller than n
		if (diff % d == 0 && diff / d < n) {
			break;
		}
		d++;	
	}
	// STEP 1: Fill elements between x and y
	// total number of middle terms between x and y
	int middleTerms = diff/d - 1;

	for (int i = 0; i <= middleTerms; i++) {
		// add terms of AP between x and y
		dq.push_back(x + d * i);
		// decrease total number of required elements
		n--;
	}

	dq.push_back(y);
	n--;

	// STEP 2: Fill elements between 0 and x
	int curr = x - d;

	while (n > 0 && curr > 0) {
		dq.push_front(curr);
		curr -= d;
		n--;
	}

	// STEP 3: fill elements beyong y
	curr = y + d;

	while (n > 0) {
		dq.push_back(curr);
		curr += d;
		n--;
	}

	for (int element: dq) {
		cout << element << " ";
	}

	cout  << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	int t;
	cin >> t;

	while (t--) {
		solve();
	}

	return 0;
}
