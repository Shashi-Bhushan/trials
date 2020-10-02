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
		a.resize(row, vector<ll>(col));
	}

	/*Matrix operator[](int index) {
		return a[index];
	}*/

	Matrix operator*(const Matrix& other) {
		Matrix result(a.size(), other.a[0].size());

		REP(i, a.size()) REP(k, a[0].size()) REP(j, other.a[0].size()) {
			result.a[i][j] += a[i][k] * other.a[k][j];

			if (result.a[i][j] >= MOD) {
				result.a[i][j] %= MOD;
			}
		}

		return result;
	}

	static Matrix identity(int order) {
		Matrix identity(order, order);

		REP(i, order) identity.a[i][i] = 1;

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
	int n;
	ll k;
	cin >> n;
	cin >> k;

	int s = n + 3;

	Matrix base(1, s);

	REP(i, n)
	cin >> base.a[0][n - 1];

	base.a[0][n] = 1;
	base.a[0][n + 1] = n;
	base.a[0][n + 2] = n * n;

	Matrix trans(s, s);

	REP(i, n) {
		trans.a[i + 1][i] = 1;
	}

	REP(i, n) {
		cin >> trans.a[n - i - 1][n - 1];
	}


	int p, q, r;
	cin >> p >> q >> r;

	// ROW n - 1
	trans.a[n][n - 1] = p;
	trans.a[n + 1][n - 1] = q;
	trans.a[n + 2][n - 1] = r;
	// Row n
	trans.a[n][n] = 1;
	trans.a[n][n + 1] = 1;
	trans.a[n][n + 2] = 1;
	// row n + 1
	trans.a[n + 1][n + 1] = 1;
	trans.a[n + 1][n + 2] = 2;
	// row n + 2
	trans.a[n + 2][n + 2] = 1;

	cout << "base ::" << endl;
	REP(i, s) 
					cout << base.a[0][i] << " ";
	cout  << endl;

	cout << "Transpose :: "  << endl;
	REP(i, s) {
		REP(j, s)	{
			cout << trans.a[i][j] << " ";
		}

		cout << endl;
	}

	trans = Matrix::power(trans, k - n + 1);
	/*cout << "base ::" << endl;
	REP(i, s) 
					cout << (base * trans).a[0][i] << " ";
	cout  << endl;

	cout << "Transpose :: "  << endl;
	REP(i, s) {
		REP(j, s)	{
			cout << trans.a[i][j] << " ";
		}

		cout << endl;
	}
	

	vector<int> new_dp(n + 3);
	REP(i, n + 3) REP(j, n + 3)
		new_dp[j] = (new_dp[j] + (ll)base.a[0][i] * trans.a[i][j])% MOD;
	*/

	cout << (base * trans).a[0][n - 1];
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
