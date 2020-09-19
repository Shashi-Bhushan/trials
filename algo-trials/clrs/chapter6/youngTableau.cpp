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

const int INF = 1e9+7;

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

const int MOD = 1e9 + 7;

class YoungTableau {
	vector<vi> arr;

	void swap(int i, int j, int k, int l) {
		int temp = arr[i][j];
		arr[i][j] = arr[k][l];
		arr[k][l] = temp;
	}

	// Insert the element at (row, col) to it's correct position
	void insertTableauify(int row, int col) {
		int largestRow = row;
		int largestCol = col;

		if (row > 0 && arr[row - 1][col] > arr[largestRow][largestCol]) {
			largestRow = row - 1;
		}

		if (col > 0 && arr[row][col - 1] > arr[largestRow][largestCol]) {
			largestRow = row;
			largestCol = col - 1;
		}

		if (!(row == largestRow && col == largestCol)) {
			swap(row, col, largestRow, largestCol);

			this->insertTableauify(largestRow, largestCol);
		}
	}

	void deleteTableauify(int row, int col) {
		int smallestRow = row;
		int smallestCol = col;

		if (row < sz(arr) - 1 && arr[row + 1][col] < arr[smallestRow][smallestCol]) {
			smallestRow = row + 1;
		}

		if (col < sz(arr[0]) - 1 && arr[row][col + 1] < arr[smallestRow][smallestCol]) {
			smallestRow = row;
			smallestCol = col + 1;
		}

		if (!(row == smallestRow && col == smallestCol)) {
			swap(row, col, smallestRow, smallestCol);

			this->deleteTableauify(smallestRow, smallestCol);
		}
	}

	int larger(int a, int b) {
		return a > b ? a : b;
	}

	int smaller (int a, int b) {
		return a > b ? b : a;
	}

public:
	YoungTableau(int row, int col) {
		arr = vector<vi>(row, vector<int>(col, INF));
	}

	void insert(int key) {
		int i = sz(arr) - 1;
		int j = sz(arr[0]) - 1;

		if (arr[i][j] != INF) {		
			cout << "!! OVERFLOW. Not inserting " << key << " in tableau" << endl;
			return;
		}

		arr[i][j] = key;

		insertTableauify(i, j);
	}
	
	int deleteMin() {
		int i = 0;
		int j = 0;

		if (arr[i][j] == INF) {
			cout << "!! Underflow. tableau is empty" << endl;
		}

		int ret = arr[i][j];

		arr[i][j] = INF;

		deleteTableauify(i, j);
		return ret;
	}

	bool contains(int key) {
		int row = 0;
		int col = 0;

		while (row < sz(arr) && arr[row][col] < key) {
			if (arr[row][col] == key) return true;
			else
				row++;
		}

		while (row > 0 && col < sz(arr[0])) {
			if (arr[row][col] == key) {
				return true;
			} else if (arr[row][col] < key) {
				col++;
			} else if (arr[row][col] > key) {
				row--;
			}
		}

		return false;
	}

	string toString() {
		string s;

		for (auto a: arr) {
			for (auto b: a) {
				s += to_string(b) + " ";
			}

			s += "\n";
		}

		return s;
	}
};


int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	YoungTableau* tableau = new YoungTableau(4,4);

	tableau->insert(2);
	tableau->insert(4);
	tableau->insert(3);
	tableau->insert(16);
	tableau->insert(5);
	tableau->insert(6);
	tableau->insert(7);
	tableau->insert(8);

	cout << tableau->toString() << endl;

	cout << "Minimum element is :: " << tableau->deleteMin() << endl;
	
	cout << tableau->toString() << endl;

	cout << tableau->contains(6) << endl;
	cout << tableau->contains(4) << endl;
	cout << tableau->contains(16) << endl;
	return 0;
}
