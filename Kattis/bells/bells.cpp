#include <iostream>
#include <vector>

using namespace std;

void swap(string &s, int i, int j) {
	char c = s[i];
	s[i] = s[j];
	s[j] = c;
}

vector<string> createSolution(char k, vector<string> prev) {
	vector<string> solution;
	for (int i = 0; i < (int)prev.size(); ++i) {
		string s = prev[i];
		int start, end, step;
		if (i % 2 == 0) {
			s += k;
			start = s.size() - 1;	
			end = 0;
			step = -1;
		} else {
			s = k + s;
			start = 0;
			end = s.size() - 1;
			step = 1;
		}
		solution.push_back(s);
		while (start != end) {
			swap(s, start, start + step);	
			solution.push_back(s);
			start += step;
		}	
	}
	return solution;
}

int main() {
	vector<vector<string> > solutions(9);
	vector<string> first(1);
	first[0] = "1";
	solutions[1] = first;
	for (int i = 2; i <= 8; ++i) {
		solutions[i] = createSolution((char)(i + '0'), solutions[i-1]);		
	}
	int p;
	cin >> p;
	for (int j = 0; j < (int)solutions[p].size(); ++j) {
		string print = "";
		for (int i = 0; i < (int)solutions[p][j].size(); ++i) {
			if (i == 0) {
				print = print + solutions[p][j][i];
			} else {
				print = print + " " + solutions[p][j][i];	
			}
		}
		cout << print << endl;
	} 
}
