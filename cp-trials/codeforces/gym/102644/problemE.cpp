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

bool inside(int row, int col) {
	return 0 <= min(row, col) && max(row, col) < 8;
}

void solve() {
	//unsigned int ans;
	//unsigned int dp[8][8];

	// 0..63 are cells of board, 64th is the answer variable
	vector<unsigned int> dp(65);
	dp[0] = 1;

	int k;
	cin >> k;
	k++;

	REP(repeat, k) {
		vector<unsigned int> newDp(65);

		REP(i, 8) {
			REP(j, 8) {
				for (int dr : {-2,-1,1,2}) {
					for (int dc: {-2,-1,1,2}) {
						if (abs(dr) != abs(dc)) {
							int row = i + dr;
							int col = j + dc;

							if (inside(row, col)) {
								newDp[8 * row + col] += dp[8 * i + j];
							}
						}
					}
				}
			}
		}

		// newDp[64] == 0 at this point anyhow
		newDp[64] += dp[64];

		REP(row, 8) REP(col, 8) {
			newDp[64] += dp[8 * row + col];
		}
		dp = newDp;
	}

	cout << dp[64] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
