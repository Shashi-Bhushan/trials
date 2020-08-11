#include <iostream>
#include <string>
#include <list>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;

int count(int x) {
  int ans = x / 9;
 
	if (x % 9 != 0) {
		ans++;
	}	 

	return ans;
}

int main() {
  int t;
  cin >> t;
  
  for (int i = 0; i < t; i++) {
    int c, r;
    cin >> c;
    cin >> r;
    
    int cans = count(c);
    int rans = count(r);
    
    if (cans < rans) {
      cout << "0 " << cans << endl;
    } else {
      cout <<  "1 " << rans << endl;
    }
  }
}
