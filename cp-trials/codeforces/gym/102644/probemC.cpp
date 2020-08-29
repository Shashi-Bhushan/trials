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

const int MOD = 1e9 + 7;

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

struct Matrix {
	vector<vector<ll>> a;

	Matrix(int row, int col) {
		a.resize(row, vector<ll>(col));

		REP(i, row) REP(j, col) {
			a[i][j] = 0;
		}
	}

	Matrix operator*(const Matrix& other) {
		Matrix result(a.size(), other.a[0].size());

		REP(i, a.size()) REP(j, a[0].size()) REP(k, other.a[0].size()) {
			result.a[i][k] += (a[i][j] * other.a[j][k]);

			if (result.a[i][k] >= MOD) {
				result.a[i][k] %= MOD;
			}
		}

		return result;
	}

	Matrix copy() {
		Matrix copy(a.size(), a[0].size());

		REP(i, 2) REP(j, 2) {
			copy.a[i][j] = a[i][j];
		}

		return copy;
	}

	Matrix identity(int order) {
		Matrix result(order, order);

		REP(i, order) {
			result.a[i][i] = 1;
		}

		return result;
	}

	Matrix power(ll power) {
		Matrix result = identity(a.size());

		Matrix copy = this->copy();

		while (power) {
			if (power & 1) {
				result = result * copy;
			}

			copy = copy * copy;
			power = power >> 1;
		}

		return result;

	}
};

void solve() {
	Matrix trans(2, 2);

	trans.a = {
		{0, 1},
		{1, 1}
	};

	ll x;
	cin >> x;

	Matrix base(1, 2);
	base.a = {{0, 1}};

	cout << (base * trans.power(x)).a[0][0] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
