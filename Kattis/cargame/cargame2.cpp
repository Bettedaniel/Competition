#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int max(int a, int b) {
    return a > b ? a : b;
}

string toLowerCase(string s) {
    int sz = s.size();
    for (int i = 0; i < sz; ++i) {
        s[i] = tolower(s[i]);
    }
    return s;
}

char match(string a, string b) {
    int i = 0;
    int SZ = b.size();
    for (int k = 0; k < SZ; ++k) {
        if (a[i] == b[k]) {
            ++i;
        }
    }
    if (i == 3) return 1;
    return 0;
}

int main() {
	ios_base::sync_with_stdio(false);
    int a, b;
    cin >> a >> b;
    vector<string> dic(a);
    for (int i = 0; i < a; ++i) {
        cin >> dic[i];
    }
    queue<string> tests;
    string s;
    for (int i = 0; i < b; ++i) {
        cin >> s;
        tests.push(toLowerCase(s));
    }
    while (!tests.empty()) {
        s = tests.front();
        tests.pop();
        string ans = "";
        for (int i = 0; i < a; ++i) {
            if (match(s, dic[i])) {ans = dic[i]; break;}
        }
        if (ans != "") {
            cout << ans << endl;
        } else {
            cout << "No valid word" << endl;
        }

    }
}
