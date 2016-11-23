#include<iostream>
using namespace std;

bool judge(char *str, int s, int e) {
	if (s >= e) return 1;
	if (str[s] != str[e]) return 0;
	else return judge(str, s + 1, e - 1);
}

int main() {

	char a[] = "abcdedcba";
	cout << a<<endl;
	cout << judge(a, 0, 8);

	return 0;
}