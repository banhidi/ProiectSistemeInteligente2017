#include <iostream>
#include <cstdio>

using namespace std;

template <typename T>
class LinkedList {

private:
	struct Node {
		T data;
		struct Node *next;
	};

	int length;
	struct Node *first;

public:
	LinkedList() {
		first = NULL;
		length = 0;
		printf("Created\n");
	}

	~LinkedList() {
		struct Node *curr, *prev;
		for(curr=first->next, prev = first; curr != NULL; curr = curr->next, prev = prev->next)
			delete prev;
		delete prev;
		first = NULL;
	}

	void addLast(T element) {
		if (element == NULL)
			return;
		struct Node *n = new struct Node;
		n->data = element;
		n->next = NULL;
		if (first == NULL)
			first = n;
		else {
			struct Node *t;
			for(t = first; t->next != NULL; t = t->next);
			t->next = n;
		} 
		length++;
	}

	bool contains(T element) {
		if (element == NULL || first == NULL)
			return false;
		struct Node *t;
		for(t = first; t != NULL; t = t->next)
			if (t.data == element)
				return true;
		return false;
	}

	T get(int index) {
		if (index < 0 || index >= length) 
			return NULL;
		int i = 0;
		for(struct Node *t = first; t != NULL; t = t->next, i++)
			if (i == index) {
				return t->data;
			}
		return NULL;
	}

	T put(T element, int index) {
		if (index < 0 || index >= length) 
			return;
		int i = 0;
		for(struct Node *t = first; t != NULL; t = t->next, i++)
			if (i == index) {
				t->data = element;
				return;
			}
	}

	string toString() {
		string s = "length=" + length;
		for(struct Node *t = first; t != NULL; t = t->next)
			s += ", " + t->data;
		return s;
	}

};

string toString(LinkedList<int> list) {
	string s = "length=" + list.length();
	for(int i = 0; i < list.length(); i++)
		s += "element[" + i + "]=" + list.get(i);

}

int main() {
	LinkedList<int> list = LinkedList<int>();
	printf("%s\n", list.toString().c_str());
	for(int i = 0; i < 10; i++) {
		list.addLast(i);
		printf("%s\n", list.toString().c_str());
	}
	return 0;
}