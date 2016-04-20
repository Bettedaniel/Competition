#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <functional>

using namespace std;

typedef pair<string, string> pis;

string transform(string cls) {
	string result = "";
	int i = 0;
	while (i < (int)cls.size()) {
		string s = "";
		for (int j = i; j < (int)cls.size(); ++j) {
			if (cls[j] == '-' || (j == (int)cls.size() - 1)) {
				if (j == (int)cls.size() - 1) {
					s = s + cls[j];	
				}
				if (s == "lower") {
					result = result + "0";
				} else if (s == "middle") {
					result = result + "1";	
				} else {
					result = result + "2";
				}
				i = j+1;
				break;
			}	
			s = s + cls[j];
		}	
	}
	return result;
}

int makeNumber(string cls, int mx) {
	int result = 0;
	int j = 0;
	for (int i = cls.size() - 1; i >= 0; --i) {
		result += pow(3, mx - j) * (cls[i] - '0');	
		++j;
	}
	return result;
}

string prettyName(string s) {
	string r = "";
	for (int i = 0; i < (int)s.size() - 1; ++i) {
		r = r + s[i];
	}	
	return r;
}

string makeLongest(string s, int mx) {
	int sz = s.size();
	for (int i = 0; i < mx - sz; ++i) {
		s = "1" + s;	
	}
	return s;
}

bool myFunc(pis u, pis v) {
	if (u.first == v.first) {
		return u < v;	
	} else {
		return u > v;	
	}
}

int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; ++t) {
		int N;
		cin >> N;	
		vector<string> names(N);
		vector<string> clss(N);
		string dummy;
		for (int i = 0; i < N; ++i) {
			cin >> names[i] >> clss[i] >> dummy;	
		}
		int mx = 0;
		for (int i = 0; i < N; ++i) {
			clss[i] = transform(clss[i]);
			mx = max(mx, (int)clss[i].size());
		}
		vector<pis> list;
		for (int i = 0; i < N; ++i) {
			string s = makeLongest(clss[i], mx);
			reverse(s.begin(), s.end());
			list.push_back(make_pair(s, names[i]));	
		}
		sort(list.begin(), list.end(), myFunc);
		for (int i = 0; i < N; ++i) {
			cout << prettyName(list[i].second) << endl;	
		}
		for (int i = 0; i < 30; ++i)
			cout << "=";
		cout << endl;
	}		
}
