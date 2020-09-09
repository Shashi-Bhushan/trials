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

int n, k;
string s, t;
int dp[201][201][201]; // [index][remaining k][# seen t[0] upto this point]



int maxOccurrence() {
	int count = 0;

	for (auto a: s) {
		if (a == t[0]) {
			count++;
		}
	}

	count = max(n, count + k);

	return ((count - 1) * count) >> 1;
}

int solve(int index, int remK, int first) {
	if (index == n) return 0;

	if (dp[index][remK][first] != -1) 
		return dp[index][remK][first];

	int ans = 0;

	if (remK == 0) {
		if (s[index] == t[1]) 
			ans = first + solve(index + 1, 0, first);
		else 
			ans = solve(index + 1, 0, first + (s[index] == t[0]));
	} else {
		if (s[index] == t[0]) {
			int ans1 = solve(index + 1, remK, first + 1); // leave as it is
			int ans2 = first + solve(index + 1, remK - 1, first); // change to b

			ans = max(ans1, ans2);
		} else if (s[index] == t[1]) {
			int ans1 = first + solve(index + 1, remK, first); // leave as it is
			int ans2 = solve(index + 1, remK - 1, first + 1); // change to a

			ans = max(ans1, ans2);
		} else {
			int ans1 = solve(index + 1, remK, first); // leave as it is
			int ans2 = first + solve(index + 1, remK - 1, first); // change to b
			int ans3 = solve(index + 1, remK - 1, first + 1); // change to a

			ans = max(ans1, max(ans2, ans3));
		}
	}

	return dp[index][remK][first] = ans;
}

void solve() {
	cin >> n;
	cin >> k;

	cin >> s;
	cin >> t;

	if (t[0] == t[1]) {
		cout << maxOccurrence() << endl;
	} else {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				for (int k = 0; k < n; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		cout << solve(0, k, 0) << endl;
	}
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	int t;
	cin >> t;

		solve();

	return 0;
}
