#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;

struct Node {
	Node(int i, int j) : i(i), j(j) {}	
	int i, j;
};

char toLowerCase(char upper) {
	return (char)((upper - 'A') + 'a');
}

int bfs(const vector<vector<Node> > &g, const string &query, const vector<string> &dict, const vector<vector<int> > &starts) {
	// (depth, (i, j))
	typedef pair<int, Node> pin;
	queue<pin> q;
	for (int i = 0; i < N; ++i) {
		int j = starts[toLowerCase(query[0])][i];
		if (j != -1) {
			q.push(make_pair(0, Node(i, j)));
		}	
	}
	while (!q.empty()) {
		pin u = q.front();
		q.pop();
		if (u.first == 2) {
			return u.second.i;	
		}
		for (int i = 0; i < (int)g[dict[u.second.i][u.second.j]].size(); ++i) {
			Node v = g[dict[u.second.i][u.second.j]][i];
			if (u.second.i == v.i && u.first + 1 <= 2 && toLowerCase(query[u.first + 1]) == dict[v.i][v.j]
				&& u.second.j < v.j) {
				q.push(make_pair(u.first + 1, Node(v.i, v.j)));	
			}
		}
	}
	return -1;
}

int main() {
//	ios_base::sync_with_stdio(false);
	cin >> N >> M;
	vector<string> dictionary(N);
	for (int i = 0; i < N; ++i) {
		cin >> dictionary[i];	
	}
	vector<string> queries(M);
	for (int j = 0; j < M; ++j) {
		cin >> queries[j];
	}
	vector<vector<Node> > graph('z'+1);
	for (int i = 0; i < N; ++i) {
		string s = dictionary[i];
		for (int j = 0; j < (int)s.size(); ++j) {
			for (int j1 = j+1; j1 < (int)s.size(); ++j1) {
				graph[s[j]].push_back(Node(i, j1));		
			}
		}
	}
	vector<vector<int> > starts('z'+1, vector<int>(N, -1));
	for (int c = 'a'; c <= 'z'; ++c) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < (int)dictionary[i].size(); ++j) {
				if (dictionary[i][j] == c) {
					starts[c][i] = j;	
					break;
				}
			}	
		}	
	}
	for (int i = 0; i < M; ++i) {
		string q = queries[i];
		int r = bfs(graph, q, dictionary, starts);
		if (r == -1) {
			cout << "No valid word" << endl;	
		} else {
			cout << dictionary[r] << endl;	
		}
	}
}
