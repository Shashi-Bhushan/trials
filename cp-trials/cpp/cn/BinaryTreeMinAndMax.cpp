pair<int, int> getMinAndMax(BinaryTreeNode<int> *root) {
	// Write your code here
    if (root == NULL) return {1000000, -10000000};
    else if (root -> left == NULL && root -> right == NULL) {
        return {root->data, root->data};
    }
    else {
        pair<int, int> left = getMinAndMax(root->left);
        pair<int, int> right = getMinAndMax(root->right);

        return {
            min(root->data, min(left.first, right.first)),
            max(root->data, max(left.second, right.second))
        };
    };
}
