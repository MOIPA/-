#include <iostream>
using namespace std;
#define lcm(a,b) (a*b/gcd(a,b))
int gcd(int a, int b) {
	while (a != b) a>b ? a -= b : b -= a;
	return a;
}
int main(void) {
	int a, b, ans = 0, i;
	cin >> a >> b;
	int t = a*b;
	for (int i = a; i <= b; i += a)
		if (t%i == 0 && lcm(i, t / i) == b)
			ans++;
	cout << ans << endl;
	return 0;
}