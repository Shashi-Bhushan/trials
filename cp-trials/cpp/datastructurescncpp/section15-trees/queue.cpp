#include<iostream>
using namespace std;

class Node {
public:
	Node *leftChild;
	int data;
	Node *rightChild;
};

class Queue{
private:
		int size;
		// Next to front is the position where to delete Node
		int front;
		// rear is position where last entered Node is
  	int rear;
		// Node pointer array 
		// (Node *) means pointer of Node
		// *Q means array
		Node **Q;  

public:
	Queue() {
		front = rear = -1;
		size = 10;
		Q = new Node*[size];
	}

	Queue(int size) {
		front = rear = -1;

		this->size = size;
		Q = new Node*[this->size];
	}

	void enqueue(Node * x);

	Node * dequeue();

	void display();

	bool isEmpty();
};

/*void Queue::create(Queue *queue, int size) {
	queue->size = size;
	queue->front = queue->rear = 0;
	queue->Q = (int*)malloc(queue -> size * sizeof(int));
}*/

void Queue::enqueue(Node * element) {
	if (rear == size - 1) {
		cout << "Queue is full" << endl;
	} else {
		rear++;
		Q[rear] = element;
	}
}

Node * Queue::dequeue() {
	Node * x = NULL;

	if (isEmpty()) {
		cout << "Queue is Empty" << endl;
	} else {
		x = Q[front + 1];
		front++;
	}	

	return x;
}

void Queue::display() {
	for (int i = front + 1; i <= rear; i++) {
		cout << Q[i] << " ";
	}
}

bool Queue::isEmpty() {
	return front == rear;
}

class Tree {
public:
	Node *root;
	Tree() {
		root = NULL;
	}

	void createTree() {
		Node *p, *t;

		Queue q(100);

		int x;
		cout << "Enter the root node's value " << endl;
		cin >> x;

		root = new Node;
		root->data = x;
		root->leftChild = root->rightChild = NULL;

		q.enqueue(root);

		while(!q.isEmpty()) {
			p = q.dequeue();

			cout << "Enter left child of " << p->data << endl;
			cin >> x;

			if (x != -1) {
				t = new Node;

				t->data = x;
				t->leftChild = t->rightChild = NULL;
				p->leftChild = t;

				q.enqueue(t);
			}

			cout << "Enter right child of " << p->data << endl;
			cin >> x;

			if (x != -1) {
				t = new Node;
				
				t->data = x;
				t->rightChild = t->leftChild = NULL;
				p->rightChild = t;

				q.enqueue(t);
			}
		}
	}

	void preOrder() {
		preOrder(root);
	}

	void preOrder(Node *p) {
		if (p != NULL) {
			cout << p->data << " ";
			preOrder(p->leftChild);
			preOrder(p->rightChild);
		}
	}

	void postOrder() {
		postOrder(root);
	}

	void postOrder(Node *p) {
		if (p != NULL) {
			postOrder(p->leftChild);
			postOrder(p->rightChild);
			cout << p->data << " ";
		}
	}

	void inOrder() {
		inOrder(root);
	}

	void inOrder(Node *p) {
		if (p != NULL) {
			inOrder(p->leftChild);
			cout << p->data << " ";
			inOrder(p->rightChild);
		}
	}

	void levelOrder() {
		levelOrder(root);
	}

	void levelOrder(Node *root) {
		Queue q(100);

		cout << root->data << " ";
		q.enqueue(root);

		while(!q.isEmpty()){
			root = q.dequeue();

			if (root->leftChild != NULL) {
				cout << root->leftChild->data << " ";
				q.enqueue(root->leftChild);
			}

			if (root->rightChild != NULL) {
				cout << root->rightChild->data << " ";
				q.enqueue(root->rightChild);
			}
		}		
	}

	int height(Node *root) {
		if (root == NULL) {
			return 0;
		} else {
			int x = height(root->leftChild);
			int y = height(root->rightChild);

			if (x > y) return x + 1;
			else return y + 1;
		}
	}
};

int main() {
	Tree t;
	t.createTree();
	cout << "preorder for the tree ::" << endl;
	t.preOrder();
	cout << endl;

	cout << "inorder for the tree ::" << endl;
	t.inOrder();
	cout << endl;
}
