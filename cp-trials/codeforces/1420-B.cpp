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

int msd(int a) {
	int ans = 0;

	while (a) {
		ans++;
	
		a = (a >> 1);
	}

	return ans;
}

unordered_map<int, int> m;

void solve() {
	int n;
	cin >> n;

	int arr[n];

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++) {
		arr[i] = msd(arr[i]);
	}

	for (int i = n - 1; i >= 0; i--) {
		m[arr[i]]++;
	}

	ll ans = 0;

	for (int i = 0; i < n; i++) {
		m[arr[i]]--;

		ans += m[arr[i]];
	}

	cout << ans << endl;
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
