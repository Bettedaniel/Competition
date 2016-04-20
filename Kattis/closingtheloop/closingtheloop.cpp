#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int convertBase10(string s) {
	int result = 0;
	for (int i = s.size() - 1; i >= 0; --i) {
		result += (s[i] - '0') * pow(10, s.size() - 1 - i); 	
	}
	return result;
}

int main() {
	int tc;
	cin >> tc;
	for (int t=0; t<tc; ++t) {
		int ropes;
		cin >> ropes;
		vector<int> blues;
		vector<int> reds;
		string rope;
		for (int i = 0; i < ropes; ++i) {
			cin >> rope;	
			if (rope[rope.size()-1] == 'B') {
				rope.pop_back();
				blues.push_back(convertBase10(rope));	
			} else {
				rope.pop_back();
				reds.push_back(convertBase10(rope));	
			}
		}
		sort(blues.begin(), blues.end(), greater<int>());
		sort(reds.begin(), reds.end(), greater<int>());
		int i = 0;
		int j = 0;
		int result = 0;
		while (i < (int)blues.size() && j < (int)reds.size()) {
			result += (blues[i] - 1) + (reds[i] - 1);
			++i;
			++j;
		}
		cout << "Case #" << (t+1) << ": " << result << endl;
	}	
}
