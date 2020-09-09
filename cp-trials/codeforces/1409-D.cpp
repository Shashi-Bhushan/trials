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

int sum(ll n) {
	int ans = 0;

	while (n) {
		ans += n % 10;
		n /= 10;
	}

	return ans;
}

void solve() {
	ll n;
	int s;

	cin >> n;
	cin >> s;

	if (sum(n) <= s) {
		cout << 0 << endl;
		return;
	}

	ll power = 1;
	ll ans = 0;
	for (int i = 0; i < 18; i++) {
		int digit = (n / power) % 10;

		ll add = (10 - digit) * power;

		ans += add;
		n += add;


		if (sum(n) <= s) break;

		power *= 10;
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
