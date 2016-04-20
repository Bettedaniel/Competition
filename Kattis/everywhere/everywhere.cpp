#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 0; t < T; ++t) {
		int N;
		cin >> N;
		string city;
		map<string, int> mapping;
		int result = 0;
		for (int i = 1; i <= N; ++i) {
			cin >> city;	
			if (mapping[city] == 0) {
				mapping[city] = i;	
				++result;
			}
		}

		cout << result << endl;
	}		
}
