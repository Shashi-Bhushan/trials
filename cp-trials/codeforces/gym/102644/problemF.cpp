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
#include<bits/stdc++.h>

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

const ll INF = 3e18L + 5;

struct Matrix {
	vector<vector<ll>> a;

	Matrix(int row, int col) {
		a.resize(row, vector<ll>(col, INF));
	}

	/*Matrix operator[](int index) {
		return a[index];
	}*/

	Matrix operator*(const Matrix& other) {
		Matrix result(a.size(), other.a[0].size());

		REP(i, a.size()) REP(k, a[0].size()) REP(j, other.a[0].size()) {
			result.a[i][j] = min(result.a[i][j], a[i][k] + other.a[k][j]);
		}

		return result;
	}

	static Matrix identity(int order) {
		Matrix identity(order, order);

		REP(i, order) identity.a[i][i] = 0;

		return identity;
	}

	static Matrix copy(const Matrix& m) {
		Matrix copy(m.a.size(), m.a[0].size());

		REP(i, m.a.size()) REP(j, m.a[0].size()) {
			copy.a[i][j] = m.a[i][j];
		}

		return copy;
	}

	static Matrix power(Matrix &m, int power) {
		Matrix result = identity(m.a.size());

		//Matrix copy = copy(m);

		while (power) {
			if (power & 1) {
				result = result * m;
			}

			m = m * m;
			power = power >> 1;
		}

		return result;
	}
};

void solve() {
	int n, m, k;
	cin >> n >> m >> k;

	Matrix single(n, n);

	REP(i, n) REP(j, n) single.a[i][j] = INF;

	while (m--) {
		int u, v, c;
		cin >> u >> v >> c;

		single.a[u - 1][v - 1] = c;
	}
	
	single = Matrix::power(single, k);

	ll ans = INF;
	REP(i, n) REP(j, n)
		ans = min(ans, single.a[i][j]);


	if (ans < INF / 2)
		cout << ans;
	else cout << "IMPOSSIBLE";
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
