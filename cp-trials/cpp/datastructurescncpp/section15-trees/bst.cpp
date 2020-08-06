#include<iostream>
using namespace std;

class Node{
public:
	Node * left;
	int data;
	Node * right;
};

class BST{
	Node * root;

	Node * insert(Node * node, int key) {
		// insert a new node
		if (node == NULL) {
			Node *t = new Node;

			t->data = key;
			t->left = NULL;
			t->right = NULL;

			return t;
		} else {
			if (key < node->data) {
				node->left = insert(node->left, key);
			} else if (key > node->data) {
				node->right = insert(node->right, key);
			}

			return node;
		}
	}

public:
	BST() {
		root = NULL;
	}

	void insertRecur(int key) {
		if (root == NULL) {
			root = insert(NULL, key);
		} else {
			insert(root, key);
		}
	}

	// Non Recursive insert
	// Search position where key is to be entered and create node there
	void insert(int key) {
		Node *node = root;
		Node *prev = NULL;

		while (node != NULL) {
			prev = node;

			if (key == node->data) {
				return;
			} else if (key < node->data) {
				node = node->left;
			} else {
				node = node->right;
			}
		}

		Node *newNode = new Node;
		newNode->data = key;
		newNode->left = NULL;
		newNode->right = NULL;

		if (prev == NULL) {
			root = newNode;
		}
		else if (prev->data > key) {
			prev->left = newNode;
		} else {
			prev->right = newNode;
		}
	}

	Node *search(int key) {
		Node *node = root;

		while (node != NULL) {
			if (node->data == key) {
				return node;
			} else if (node->data > key) {
				node = node->left;
			} else {
				node = node->right;
			}
		}

		return NULL;
	}
};

int main() {
	BST bst;
	cout << "Creating Binary Tree" << endl;
	cout << "How many elements in BST?" << endl;

	int x;
	cin >> x;

	while (x-- > 0) {
		cout << "Node value " << endl;
		int y;
		cin >> y;

		bst.insert(y);
	}

	cout << "Element to search for in BST" << endl;
	int search;
	cin >> search;

	Node * searchedNode = bst.search(search);
	if (searchedNode == NULL) {
		cout << "Didn't found the data in BST" << endl;
	} else {
		cout << "Found the data in BST" << endl;
	}

	return 0;
}
