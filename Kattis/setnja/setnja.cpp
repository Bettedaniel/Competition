#include <iostream>
#include <vector>

using namespace std;

void allPoss(string s, int length) {
	if (length == 0) {
		cout << s << endl;	
	} else {
		allPoss(s + "L", length - 1);
		allPoss(s + "R", length - 1);	
		allPoss(s + "P", length - 1);
	}
}

int main() {
	allPoss("", 3);	
}
