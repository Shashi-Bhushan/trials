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

		int a = 0;
		while (a < n && k > 0) {
			a += k;
			k /= 2;
		}

		//cout << a << " " << k << endl;
		if (a < n) {
			cout << "0" << endl;
		} else {
			cout << "1" << endl;
		}
	}
}
