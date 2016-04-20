#include <iostream>

using namespace std;

int main() {
	string s;
	cin >> s;
	int result = 0;
	int n = s.size();
	for (int i = 0; i < n; i += 3)	{
		if (s[i] != 'P') {
			++result;	
		}
		if (i+1 < n && s[i+1] != 'E') {
			++result;
		}
		if (i+2 < n && s[i+2] != 'R') {
			++result;	
		}
	}
	cout << result << endl;
}
