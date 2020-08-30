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
	vector<vector<unsigned int>> a;

	Matrix(int row, int col) {
		a.resize(row, vector<unsigned int>(col));
	}

	/*Matrix operator[](int index) {
		return a[index];
	}*/

	Matrix operator*(const Matrix& other) {
		Matrix result(a.size(), other.a[0].size());

		REP(i, a.size()) REP(k, a[0].size()) REP(j, other.a[0].size()) {
			result.a[i][j] += (a[i][k] * other.a[k][j]);
		}

		return result;
	}

	Matrix identity(int order) {
		Matrix identity(order, order);

		REP(i, order) identity.a[i][i] = 1;

		return identity;
	}

	Matrix copy() {
		Matrix copy(a.size(), a[0].size());

		REP(i, a.size()) REP(j, a[0].size()) {
			copy.a[i][j] = a[i][j];
		}

		return copy;
	}

	Matrix power(int power) {
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

bool inside(int row, int col) {
	return 0 <= min(row, col) && max(row, col) < 8;
}

void solve() {
	int k;
	cin >> k;

	k++;

	// Matrix represent from each (row, col) which one of the positions I can go to
	// I will set 1 at those places
	// For eg. for point (0,0) hashed values => 8 * 0 + 0 = 0
	// so, it's represented by row 0. All values which are 1 in row 0 are the positions I can go to from point (0, 0)
	Matrix single(65, 65);
	

	REP(i, 8) {
		REP(j, 8) {
			for (int dr : {-2,-1,1,2}) {
				for (int dc: {-2,-1,1,2}) {
					if (abs(dr) != abs(dc)) {
						int row = i + dr;
						int col = j + dc;

						if (inside(row, col)) {
							single.a[8 * i + j][8 * row + col] = 1;
						}
					}
				}
			}
		}
	}

	// Setting answer column as 1 for each row
	// There's only one way to reach from (0,0) to (0,0) in 1 step.
	//
	REP(i, 65) {
		single.a[i][64] = 1;
	}

	Matrix total = single.power(k);

	cout << total.a[0][64] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
