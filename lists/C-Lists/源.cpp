#include<iostream>
#include<string>
#include"stack.h"
using namespace std;
int main(void) {
	Stack testlist;
	cout << "输入元素 exit 退出输入" << endl;
	string record;
	int count = 0;
	do {
		count++;
		cin >> record;
		cout << "输入元素  exit 退出输入" << endl;
		if (record == "exit")
			break;
		testlist.Push(record);
	} while (record != "exit");
	for (int i = 0; i < count-1; i++) {
		cout << testlist.Pop() << " ";
	}
	getchar();
}
