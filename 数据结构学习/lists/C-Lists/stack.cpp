#include "stack.h"
#include<stdlib.h>
#include<cstdlib>
#include<iostream>
#include<string>
using namespace std;
Stack::Stack()
{
	h = new Node;
	h->next = new Node;
}

void Stack::printList() {
	Node *p;
	p = h->next;
	cout << "the elements of the list is:" << endl;
	while (p != NULL) {
		cout << p->elements << endl;
		p = p->next;
	}
}

void Stack::insert(string obj, int index) {
	if (index == 1) {
		Node *p = h;
		Node *node = new Node;
		node->elements = obj;
		node->next = p->next;
		h->next = node;
	}
	else {
		int count = 0;
		Node *p = h;
		Node *node = new Node;
		node->elements = obj;

		while (p != NULL) {
			p = p->next;
			count++;
			if (count == index - 1)
				break;
		}

		node->next = p->next;
		p->next = node;

	}
}

string Stack::deleteListElement(int index) {
	Node *p;
	p = h;
	Node *temp;
	for (int i = 0; i < index - 1; i++) {
		p = p->next;
	}
	temp = p->next;
	p->next = temp->next;
	string saveText = temp->elements;
	delete temp;
	return saveText;
}

void Stack::Push(string element) {
	insert(element, 1);
}

string Stack::Pop() {
	return deleteListElement(1);
}




