#include<iostream>
#include<string>
#include"stack.h"
using namespace std;
int main(void) {
	Stack testlist;
	cout << "����Ԫ�� exit �˳�����" << endl;
	string record;
	int count = 0;
	do {
		count++;
		cin >> record;
		cout << "����Ԫ��  exit �˳�����" << endl;
		if (record == "exit")
			break;
		testlist.Push(record);
	} while (record != "exit");
	for (int i = 0; i < count-1; i++) {
		cout << testlist.Pop() << " ";
	}
	getchar();
}
