#include <iostream>
#include <vector>
#include <regex>
// Regex doesn't work with gcc.

using namespace std;

int N, M;

char toLowerCase(char c) {
	return (c - 'A') + 'a';
}

int main() {
	cin >> N >> M;
	vector<string> dict(N);
	vector<string> query(M);
	for (int i = 0; i < N; ++i) {
		cin >> dict[i];	
	}
	for (int i = 0; i < M; ++i) {
		cin >> query[i];
	}
	string s = "[a-zA-Z]*";
	for (int i = 0; i < M; ++i) {
		string regx = (s + toLowerCase(query[i][0])
                            + s + toLowerCase(query[i][1])
                            + s + toLowerCase(query[i][2])
                            + s);
		regex e(regx);
		int found = -1;
		for (int j = 0; j < N; ++j) {
			if (regex_match(dict[j], e)) {
				found = j;	
				break;
			}	
		}
		if (found == -1) {
			cout << "No valid word" << endl; 	
		} else {
			cout << dict[found] << endl;	
		}
	}
}
