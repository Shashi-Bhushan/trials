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
int arr[200002], start[200002], ending[200002];
// starts[i] = max #points we can gather from 1 interval of size k, in the region [arr[i], infinity] on x-axis
// ending[i] = max #points we can gather form 1 interval of size k, in the region [-infinity, arr[i]] on x-axis

void preProcessing() {
	int i = 0; int j = 0;

	// ending[0] = 

	while (j < n) {
		if (arr[j] - arr[i] <= k) {
			if (j) ending[j] = max(ending[j - 1], j - i + 1);
			else ending[j] = j - i + 1;

			j++;
		} else {
			i++;
		}
	}

	i = j = n - 1;

	while (i >= 0) {
		if (arr[j] - arr[i] <= k) {
			if (i == n - 1) start[i] = j - i + 1;
			else start[i] = max(start[i + 1], j - i + 1);

			i--;
		} else {
			j--;
		}
	}
}

void solve() {
	int y;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> y; //discard y
	}
	if (n == 1) {
		cout << 1 << endl;
		return;
	}

	sort(arr, arr + n);

	preProcessing();

	int ans = 0;
	for (int i = 0; i < n - 1; i++) {
		ans = max(ans, ending[i] + start[i + 1]);
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
