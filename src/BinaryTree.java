

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public TreeNode root = null;
    private List<TreeNode> nodeList = new ArrayList<TreeNode>();

    private class TreeNode {
        int key;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(int key, TreeNode leftChild, TreeNode rightChild, TreeNode parent) {
            this.key = key;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public int getKey() {
            return key;
        }

        public boolean isEmpty() {
            if (root == null) return true;
            else return false;
        }
    }

    public void add(int key) {
        TreeNode parentN = null;
        TreeNode newNode = new TreeNode(key, null, null, null);
        TreeNode pNode = root;
        if (root == null) {
            root = newNode;
            return;
        }
        while (pNode != null) {
            parentN = pNode;
            if (key < pNode.key) {
                pNode = pNode.leftChild;
            } else if (key > pNode.key) {
                pNode = pNode.rightChild;
            } else {
                return;
            }
        }
        if (key < parentN.key) {
            parentN.leftChild = newNode;
            newNode.parent = parentN;
        } else {
            parentN.rightChild = newNode;
            newNode.parent = parentN;
        }
    }

    public TreeNode search(int key) {
        TreeNode p = root;
        while (p != null && p.key != key) {
            if (key < p.key) p = p.leftChild;
            else p = p.rightChild;
        }
        return p;
    }

    public TreeNode max(TreeNode node) {
        TreeNode p = node;
        while (p.rightChild != null) {
            p = p.rightChild;
        }
        return p;
    }

    public TreeNode minElemNode(TreeNode node) {
        TreeNode pNode = node;
        while (pNode.leftChild != null) {
            pNode = pNode.leftChild;
        }
        return pNode;
    }

    public void remove(TreeNode p) {
        if (p == null) return;
        if (p.leftChild == null && p.rightChild == null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) parentNode.leftChild = null;
            else parentNode.rightChild = null;
        } else if (p.leftChild == null && p.rightChild != null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) {
                parentNode.leftChild = p.rightChild;
                p.rightChild.parent = parentNode;
            } else {
                parentNode.rightChild = p.rightChild;
                p.rightChild.parent = parentNode;
            }
        } else if (p.leftChild != null && p.rightChild == null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) {
                parentNode.leftChild = p.leftChild;
                p.leftChild.parent = parentNode;
            } else {
                parentNode.rightChild = p.leftChild;
                p.leftChild.parent = parentNode;
            }
        } else {
            p.key = max(p.leftChild).getKey();
            remove(max(p.leftChild));
        }
    }


    public BinaryTree getTree(int[] keys) {
        BinaryTree a = new BinaryTree();
        for (int key : keys) {
            a.add(key);
        }
        return a;
    }

    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.leftChild);
            nodeList.add(root);
            inOrderTraverse(root.rightChild);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p != null && q != null) {
            if (!(p.key == q.key)) return false;
        }
        if (!(p == null && q == null)) {
            if (!isSameTree(p.leftChild, q.leftChild)) {
                return false;
            }
            if (!isSameTree(p.rightChild, q.rightChild)) {
                return false;
            }
        }
        return true;
    }
}