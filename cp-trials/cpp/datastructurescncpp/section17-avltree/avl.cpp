#include <algorithm>
#include <bitset>
#include <cassert>
#include <chrono>
#include <cstring>
#include <iomanip>
#include <iostream>
#include <map>
#include <queue>
#include <random>
#include <set>
#include <stack>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// BEGIN NO SAD
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
#define f first
#define s second

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;

class Node {
public:
	Node *left;
	int data;
	int height;
	Node *right;

	Node(int data) {
		this->data = data;
		this->height = 0;
		left = NULL;
		right = NULL;
	}
};

class AVLBST {
	Node *root;

	int getHeight(Node * node) {
		int rightHeight = (node != NULL && node->right != NULL) ? node->right->height : -1;
		int leftHeight = (node != NULL && node->left != NULL) ? node->left->height : -1;

		return max(rightHeight, leftHeight) + 1;
	}

	int balanceFactor(Node * node) {
		int rightHeight = (node != NULL && node->right != NULL) ? node->right->height : -1;
		int leftHeight = (node != NULL && node->left != NULL) ? node->left->height : -1;

		return leftHeight - rightHeight;
	}

	Node *balanceNode(Node * p) {
		int nodeBf = balanceFactor(p);

		// Positive balance factor, hence left imbalance
		if (nodeBf == 2) {
			// Again positive bf, Left of left
			int bf = balanceFactor(p->left);
			
			if (bf == 1) {
				return llRotation(p);
			} else if (bf == -1) { // right of lefti
				return lrRotation(p);
			}
		} else if (nodeBf == -2) { // Negative balance factor, check right tree
			// left of right
			int bf = balanceFactor(p->right);

			if(bf == 1) {
				return rlRotation(p);
			} else if (bf == -1) { // both negative, right of right
				return rrRotation(p);
			}
		}

		return NULL;
	}

	Node *llRotation(Node *p) {
		Node *left = p->left;

		p->left = left->right;
		left->right = p;

		// since left is now root, recalculate the height of all 3 nodes
		left->height = getHeight(left);
		left->right->height = getHeight(left->right);
		left->left->height = getHeight(left->left);

		// return the root
		return left;
	}

	Node *rrRotation(Node *p) {
		Node *right = p->right;

		p->right = right->left;
		right->left = p;

		// since right is not root, recalculate the height of all 3 nodes
		right->height = getHeight(right);
		right->left->height = getHeight(right->left);
		right->right->height = getHeight(right->right);

		return right;
	}

	Node *lrRotation(Node *p) {
		return NULL;
	}

	Node *rlRotation(Node *p) {
		return NULL;
	}

public:
	AVLBST() {
		root = NULL;
	}

	void insert(int key) {
		// each time when you insert a node, the root might change, reassign the root this way then
		root = insert(root, key);
	}

	Node *insert(Node *node, int key) {
		// Since now when I insert a node, I would need to keep count of all parents to update their height
		// I would save these in a Stack
		if (node == NULL) {
			Node *newNode = new Node(key);
			newNode->height = 0;

			return newNode;
		}

		if (key < node->data) {
			node->left = insert(node->left, key);
		} if (key > node->data) {
			node->right = insert(node->right, key);
		}

		node->height = getHeight(node);

		if (balanceFactor(node) == 2) {
			if (balanceFactor(node->left) == 1) {
				return llRotation(node);
			} else if (balanceFactor(node->left) == -1) {
				//return lrRotation(node);
			}
		} else if (balanceFactor(node) == -2) {
			if (balanceFactor(node->right) == -1) {
				return rrRotation(node);
			} else if (balanceFactor(node->right) == 1) {
				//return rlRotation(node);
			}
		}

		return node;
	}


	int getHeight() {
		return getHeight(root);
	}

	vector<int> levelOrder() {
		queue<Node *> queue;

		queue.push(root);

		vi ans;

		while (!queue.empty()) {
			Node *node = queue.front();
			queue.pop();

			ans.push_back(node->data);

			if (node->left)
				queue.push(node->left);

			if(node->right)
				queue.push(node->right);
		}

		return ans;
	}

	void printLevelOrder() {
		queue<Node *> queue;

		queue.push(root);

		while (!queue.empty()) {
			Node *node = queue.front();
			queue.pop();

			if (node->left) {
				cout << "Left child of " << node->data << " is " << node->left->data << "(" << node->left->height << ")" << endl;
				queue.push(node->left);
			} else {
				cout << "Left child of " << node->data << " is NULL" << endl;
			}

			if (node->right) {
				cout << "right child of " << node->data << " is " << node->right->data << "(" << node->right->height << ")" << endl;
				queue.push(node->right);
			} else {
				cout << "Right child of " << node->data << " is NULL" << endl;
			}
		}
	}
};

Node *root = NULL;


int main() {
	// Disable synchronization b/w c and c++ streams
	ios_base::sync_with_stdio(false);
	// untie cin and cout
	cin.tie(NULL);

	AVLBST *tree = new AVLBST;

	tree->insert(20);
	tree->insert(10);
	//tree->insert(30);
	//tree->insert(15);
	tree->insert(5);
	tree->insert(3);
	tree->insert(40);
	tree->insert(50);
	tree->insert(55);

	cout << tree->getHeight() << endl;

	tree->printLevelOrder();
	return 0;
}
