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
	ll a[2][2] = {{0, 0}, {0, 0}};

	Matrix operator*(Matrix other) {
		Matrix result;

		REP(i, 2) REP(j, 2) REP(k, 2) {
			result.a[i][k] += (a[i][j] * other.a[j][k]);

			if (result.a[i][k] >= MOD) {
				result.a[i][k] %= MOD;
			}
		}

		return result;
	}

	Matrix copy() {
		Matrix copy;

		REP(i, 2) REP(j, 2) {
			copy.a[i][j] = a[i][j];
		}

		return copy;
	}

	Matrix identity() {
		Matrix result;

		REP(i, 2) {
			result.a[i][i] = 1;
		}

		return result;
	}

	Matrix power(ll power) {
		Matrix result = identity();

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
	Matrix mat;
	mat.a[0][0] = 19;
	mat.a[0][1] = 7;
	mat.a[1][0] = 6;
	mat.a[1][1] = 20;

	ll x;
	cin >> x;

	cout << mat.power(x).a[0][0] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
