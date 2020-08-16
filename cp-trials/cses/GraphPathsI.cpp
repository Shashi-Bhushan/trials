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

// BEGIN NO SAD
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define f first
#define s second

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

const int MOD = 1e9 + 7;

class Matrix {
public:
	vector<vector<ll>> mat;

	Matrix(ll n, ll m) {
		mat.resize(n, vector<ll>(m));
	}

	Matrix operator*(Matrix &m) {
		assert(mat[0].size() == m.mat.size());
		Matrix ans(mat.size(), m[0].size());

		// A's row
		for (int i = 0; i < mat.size(); i++) {
			// A's column
			for (int k = 0; k < mat[0].size(); k++) {
				for (int j = 0; j < m[0].size(); j++) {

					ans[i][j] += (mat[i][k] * m[k][j]);

					if (ans[i][j] >= MOD) {
						ans[i][j] %= MOD;
					}
				}
			}	
		}

		return ans;
	}

	vector<ll>& operator[](int index){
		return mat[index];
	}

	Matrix copy() {
		Matrix copy(mat.size(), mat[0].size());

		for (int i = 0; i < mat.size(); i++) {
			for (int j = 0; j < mat[0].size(); j++) {
				copy.mat[i][j] = mat[i][j];
			}
		}

		return copy;
	}


	static Matrix identity(int order) {
		Matrix result(order, order);

		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				if (i == j) {
					result[i][j] = 1;
				} else {
					result[i][j] = 0;
				}
			}
		}

		return result;
	}

	Matrix power(ll power) {
		Matrix m = copy();

		Matrix result = identity(mat.size());

		while (power) {
			// if power is odd
			if (power & 1) {
				result = result * m;
			}

			m = m * m;
			power = power >> 1;
		}

		return result;
	}
};

void printMatrix(Matrix m) { 
	for (int i = 0; i < m.mat.size(); i++) {
		for (int j = 0; j < m.mat[0].size(); j++) {
			cout << m[i][j] << ", ";
		}
		
		cout << endl;
	}
	cout << endl;
}

void solve() {
	int n, m, k;
	cin >> n >> m >> k;

	Matrix adj(n, n);

	while (m--) {
		int a;
		int b;
		cin >> a >> b;

		a--;b--;

		adj[a][b]++;
	}

	cout << adj.power(k)[0][n-1] << endl;

}



int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
