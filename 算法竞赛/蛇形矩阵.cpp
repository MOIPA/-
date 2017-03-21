#include<iostream>
using namespace std;

int Circle(int n, int num[][100], int l, int r) {
	int Boundsub = n - 1;
	//int l = 0, r = n - 1;
	int ret = n*n;
	for (int i = 0; i < Boundsub; i++) {
		num[l][r--] = ret--;
	}

	for (int i = 0; i < Boundsub; i++) {
		num[l--][r] = ret--;
	}
	for (int i = 0; i < Boundsub; i++) {
		num[l][r++] = ret--;
	}
	Boundsub = Boundsub;
	for (int i = 0; i < Boundsub; i++) {
		num[l++][r] = ret--;
	}
	return ret;
}

int main(void) {
	int n;
	cin >> n;
	int ret = n / 2;
	int num[100][100];
	int sum = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++)
			num[i][j] = 0;
	}

	int a = n - 1, b = n - 1, ren = n;;
	for (int i = 0; i < ret; i++) {
		Circle(ren, num, a, b);
		ren -= 2;
		a--;
		b--;

	}

	num[ret][ret] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << num[i][j] << "  ";
		cout << endl;
	}
	for (int i = 0; i < n; i++)
		sum += num[i][i];
	int count = 0;
	int countx = n - 1;
	for (int i = 0; i < n; i++) {
		sum += num[count++][countx--];
	}
	cout << sum - 1;
}