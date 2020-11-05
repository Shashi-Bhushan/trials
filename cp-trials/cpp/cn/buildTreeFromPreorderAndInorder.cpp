/***********************************************************
	Following is the Binary Tree Node class structure

	template <typename T>
	class BinaryTreeNode {
    	public :
    	T data;
    	BinaryTreeNode<T> *left;
    	BinaryTreeNode<T> *right;

    	BinaryTreeNode(T data) {
        	this -> data = data;
        	left = NULL;
        	right = NULL;
    	}
	};

***********************************************************/

int binarySearch(int *arr, int start, int end, int element) {
    while (start <= end) {
        int mid = start + (end - start) /2 ;

        if (arr[mid] == element) {
            return mid;
        } else if (arr[mid] < element) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return -1;
}

BinaryTreeNode<int>* helper(int *preorder, int*inorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd) return NULL;

    int rootValue = preorder[preStart];

    int rootIndex = binarySearch(inorder, inStart, inEnd, rootValue);

    int inLeftStart = inStart;
    int inLeftEnd = rootIndex - 1;
    int inRightStart = rootIndex + 1;
    int inRightEnd = inEnd;

    int preLeftStart = preStart + 1;
    int preLeftEnd = (inLeftEnd - inLeftStart) + preLeftStart; // inLeftEnd - inLeftStart = preLeftEnd - preLeftStart
    int preRightStart = preLeftEnd + 1;
    int preRightEnd = preEnd;


    BinaryTreeNode<int>* root = new BinaryTreeNode<int>(rootValue);

    root -> left = helper(preorder, inorder, preLeftStart, preLeftEnd, inLeftStart, inLeftEnd);
    root -> right = helper(preorder, inorder, preRightStart, preRightEnd, inRightStart, inRightEnd);

    return root;
}

BinaryTreeNode<int>* buildTree(int *preorder, int preLength, int *inorder, int inLength) {
    return helper(preorder, inorder, 0, preLength - 1, 0, inLength - 1);
}
