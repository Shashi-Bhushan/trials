#include <iostream>
#include <string>
#include <list>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;


int main() {
  int t;
  cin >> t;
  
  for (int i = 0; i < t; i++) {
    int n, k;
    cin >> n;
    cin >> k;

		int ans = -1;
		int div = INT_MAX;

		while (n--) {
			int x;
			cin >> x;
		
			if (k % x == 0 && k / x < div) {
				ans = x;
				div = k / x;
			}
		}

		if (ans == INT_MAX) {
			cout << -1 << endl;
		} else {
			cout << ans << endl;
		}
	}
}
