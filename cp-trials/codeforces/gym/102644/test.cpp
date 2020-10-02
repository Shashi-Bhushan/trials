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

struct Matrix {
	ll a[2][2] = {{0, 0}, {0, 0}};

	Matrix operator*(const Matrix& other) {
		Matrix product;

		REP(i, 2) REP(j, 2) REP(k, 2) {
			product.a[i][k] += a[i][j] * other.a[j][k];

			if (product.a[i][k] >= MOD) {
				product.a[i][k] = product.a[i][k] % MOD;
			}
		}

		return product;
	}

	Matrix copy() {
		Matrix copy;

		REP(i, 2) REP(j, 2) {
			copy.a[i][j] = a[i][j];
		}

		return copy;
	}

	Matrix identity() {
		Matrix identity;

		REP(i, 2) {
			identity.a[i][i] = 1;
		}

		return identity;
	}

	Matrix power(ll power) {
		Matrix copy = this->copy();

		Matrix result = identity();

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
	ll n;
	cin >> n;

	Matrix m;
	m.a[0][0] = 19;
	m.a[0][1] = 7;
	m.a[1][0] = 6;
	m.a[1][1] = 20;

	cout << m.power(n).a[0][0] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
