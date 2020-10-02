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
	int x;

	int prev;

	cin >> x >> prev;

	bool p = false;
	while (x-- != 1) {
		int curr;
		cin >> curr;

		if (prev <= curr && !p) {
			cout << "YES" << endl;
			p = true;
		}
		prev= curr;
	}

	if (!p)
	cout << "NO" << endl;
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
