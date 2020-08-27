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
	ll n;
	cin >> n;

	ll ar[n];

	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	ll count = 1;
	for (int i = 1; i < n; i++) {
		if (ar[i - 1] == ar[i])
			count++;
	}

	if (count == n)
		cout << count << endl;
	else
		cout << 1 << endl;
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
