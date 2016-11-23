#include<iostream>
using namespace std;
int  kp(int num[], int l, int r) {
	int i = l, j = r;
	int x = num[l];
	while (i < j&&num[j] >= x)
		j--;
	if (i < j) {
		num[i] = num[j];
		i++;
	}
	while (i < j&&num[i] < x)
		i++;
	if (i < j) {
		num[j] = num[i];
		j--;
	}
	num[i] = x;

	return i;
}
void kpsy(int num[], int l, int r) {
	if (l < r) {
		int i = kp(num, l, r);
		kpsy(num, l, i - 1);
		kpsy(num, i + 1, r);
	}
}

void kpsya(int s[], int l, int r)
{
	if (l < r)
	{
		//Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
		int i = l, j = r, x = s[l];
		while (i < j)
		{
			while (i < j && s[j] >= x) // ���������ҵ�һ��С��x����
				j--;
			if (i < j)
				s[i++] = s[j];

			while (i < j && s[i] < x) // ���������ҵ�һ�����ڵ���x����
				i++;
			if (i < j)
				s[j--] = s[i];
		}
		s[i] = x;
		kpsya(s, l, i - 1); // �ݹ����
		kpsya(s, i + 1, r);
	}
}
int main(void) {
	int num[10] = { 2,4,1,7,3,9,10,5,8,6 };
	kpsy(num, 0, 9);
	//kpsy(num, 0, 9);
	for (int i = 0; i < 10; i++)
		cout << num[i] << " ";

}