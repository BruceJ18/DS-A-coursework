package datastructures.binarytrees;

public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode left;
        private AVLNode right;


        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode node;

    public void insert(int value) {
        node = insert(node, value);
    }

    public AVLNode insert (AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        setHeight(root);

        return balance(root);
    }

    private AVLNode rightRotate(AVLNode root) {
        var newRoot = root.left;

        root.left = root.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode leftRotate(AVLNode root) {
        var newRoot = root.right;

        root.right = root.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private void setHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor( AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)){
            if (balanceFactor(root.left) < 0)
                root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.right ) > 0)
                root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
}
