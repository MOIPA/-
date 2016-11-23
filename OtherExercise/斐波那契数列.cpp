#include<iostream>
using namespace std;

int Fibsequence(int n) {
	if (n == 0)return 0;
	if (n == 1)return 1;
	if (n > 1) return Fibsequence(n - 1)+Fibsequence(n-2);
}

int main(void) {
	int n;
	cin >> n;
	cout<<Fibsequence(n);
	return 0;
}