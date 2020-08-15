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

int MOD = 1e9 + 7;

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

					ans[i][j] += (mat[i][k] * m[k][j]) % MOD;
				}
			}	
		}

		return ans;
	}

	vector<ll>& operator[](int index){
		return mat[index];
	}
};

void solve() {
	ll n;
	cin >> n;
	
	Matrix base(1, 6);
	base.mat = {
		{0,0,0,0,0,1}
	};

	Matrix trans(6, 6);
	trans.mat = {
		{0, 0, 0, 0, 0, 1},
		{1, 0, 0, 0, 0, 1},
		{0, 1, 0, 0, 0, 1},
		{0, 0, 1, 0, 0, 1},
		{0, 0, 0, 1, 0, 1},
		{0, 0, 0, 0, 1, 1}
	};

	for (int i = 0; i < n; i++) {
		base = base * trans;
	}
	/*for (int i = 0; i < base[0].size(); i++) {
		cout << base[0][i] << ", ";
	}*/
	cout << base[0][5] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	solve();

	return 0;
}
