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
#define N 300010

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

const int MOD = 1e9 + 7;

int l, r;

ll ans;

ll arr[N];

// if local maxima, add to contribution
// if local minima, remove from contribution
void ADD(int index) {
	if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
		ans += arr[index];
	} else if (arr[index] < arr[index - 1] && arr[index] < arr[index + 1]) {
		ans -= arr[index];
	}
}

void REMOVE(int index) {	
	if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
		ans -= arr[index];
	} else if (arr[index] < arr[index - 1] && arr[index] < arr[index + 1]) {
		ans += arr[index];
	}
}

void printArr(int n) {
	for (int i = 0; i <= n; i++) {
		cout << arr[i] << " ";
	}

	cout << endl;
}

void solve() {
	int n, q;
	cin >> n >> q;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	arr[0] = arr[n + 1] = ans = 0;

	for (int i = 1; i <= n; i++) {
		ADD(i);
	}

	cout << ans << endl;

	for (int i = 0; i < q; i++) {
		cin >> l >> r;

		set<int> toChange;

		for (int j = -1; j <= 1; j++) {
			if (0 < (l + j) && (l + j) < n + 1 ) toChange.insert(l + j);
			if (0 < (r + j) && (r + j) < n + 1 ) toChange.insert(r + j);
		}

		for (int index: toChange) {
			REMOVE(index);
		}

		swap(arr[l], arr[r]);

		for (int index: toChange) {
			ADD(index);
		}

		cout << ans << endl;
	}
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
