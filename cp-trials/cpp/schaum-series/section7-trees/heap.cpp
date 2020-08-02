#include<iostream>
#include<vector>
using namespace std;

class Node {
public:
	Node * lChild;
	int data;
	Node * rChild;

	Node(int data) {
		this->data = data;
	}
};

class Heap {
	Node * node[32];
	int lastIndex = 0;

	int getParent(int index) {
		int oneIndex = index + 1;
		return (oneIndex / 2) - 1;
	}

public:
	// Need to convert zero based lastIndex to one based index for parent calculation
	void offer(int data) {
		node[lastIndex] = new Node(data);

		// while node is not at correct position, check with parent
		int parent = getParent(lastIndex);
		int curr = lastIndex;

		while (parent >= 0 && node[curr]->data > node[parent]->data) {
			// swap current and parent data
			int t = node[curr]->data;
			node[curr]->data = node[parent]->data;
			node[parent]->data = t;

			curr = parent;
			parent = getParent(parent);
		}

		lastIndex++;
	}

	vector<int> levelOrder() {
		vector<int> ans;

		int i = 0;
		while (node[i] != NULL) {
			ans.push_back(node[i]->data);
			i++;
		}

		return ans;
	}


		
};

int main() {
	Heap* heap = new Heap();
	heap->offer(44);
	heap->offer(30);
	heap->offer(50);
	heap->offer(22);
	heap->offer(60);
	heap->offer(55);
	heap->offer(77);
	heap->offer(55);

	cout << "Heap elements are : ";
	for (auto a: heap->levelOrder()) {
		cout << a << " ";
	}

	cout << endl;
}
