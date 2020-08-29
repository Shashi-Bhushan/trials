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
#define REP(i ,n) for (int i = 0; i < (n); i++)
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define f first
#define s second

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

struct Matrix {
	double a[2][2] = {{0, 0}, {0, 0}};

	Matrix operator*(const Matrix& other) {
		Matrix product;

		REP(i, 2) REP(j, 2) REP(k, 2) {
			product.a[i][k] += a[i][j] * other.a[j][k];
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
	int n;
	double p; // P is probability his mood will switch
	cin >> n;
	cin >> p;

	/*vector<double> dp{1.0, 0.0};

	REP(i, n) {
		// (happy * no_switch) + (sad * switch)
		double newHappy = dp[0] * (1 - p) + dp[1] * p;
		// (happy * switch) + (sad * no_switch)
		double newSad = dp[0] * p + dp[1] * (1 - p);

		dp = {newHappy, newSad};
	}

	cout << dp[0] << endl;*/

	// Matrix Row Label: Happy
	// Matrix Col Label: probability
	// p => Probability of switch
	//
	//       | No Switch | Switch
	//  Happy| 1 - p     | p
	//  SAD  | p         | 1 - p
	Matrix single;
	single.a[0][0] = 1 - p;
	single.a[0][1] = p;
	single.a[1][0] = p;
	single.a[1][1] = 1 - p;
	
	// identity
	Matrix total;
	REP(i, 2) {
		total.a[i][i] = 1;
	}

	cout << single.power(n).a[0][0] << endl;
}

int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

		solve();

	return 0;
}
