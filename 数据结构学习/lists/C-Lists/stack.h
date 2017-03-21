#ifndef STACK_H
#define STACK_H
#include"node.h"
class Stack {
private:

	Node *h, *s, *p;

	void printList();

	void insert(string insElement, int index);

	string deleteListElement(int index);

public:

	Stack();

	void Push(string element);

	string Pop();
};

#endif