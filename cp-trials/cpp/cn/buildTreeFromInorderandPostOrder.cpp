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

BinaryTreeNode<int>* helper(int *postorder, int*inorder, int inStart, int inEnd, int postStart, int postEnd) {
    if (postStart > postEnd) return NULL;

    int rootValue = postorder[postEnd];

    int rootIndex = binarySearch(inorder, inStart, inEnd, rootValue);

    int inLeftStart = inStart;
    int inLeftEnd = rootIndex - 1;
    int inRightStart = rootIndex + 1;
    int inRightEnd = inEnd;

    int postLeftStart = postStart;
    int postLeftEnd = (inLeftEnd - inLeftStart) + postLeftStart; // inLeftEnd - inLeftStart = preLeftEnd - preLeftStart => postLeftStart + size of left array
    int postRightStart = postLeftEnd + 1;
    int postRightEnd = postEnd - 1;


    BinaryTreeNode<int>* root = new BinaryTreeNode<int>(rootValue);

    root -> left = helper(postorder, inorder, inLeftStart, inLeftEnd, postLeftStart, postLeftEnd);
    root -> right = helper(postorder, inorder, inRightStart, inRightEnd, postRightStart, postRightEnd);

    return root;
}


BinaryTreeNode<int>* buildTree(int *postorder, int postLength, int *inorder, int inLength) {
    // Write your code here
    return helper(postorder, inorder, 0, inLength - 1, 0, postLength - 1);
}
