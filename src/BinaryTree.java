import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public abstract class BinaryTree<T extends Comparable<T>> extends AbstractSet<T> implements SortedSet<T> {
    TreeNode<T> root = null;
//    private List<TreeNode> nodeList = new ArrayList<TreeNode>();

    public class TreeNode<T> {
        T key;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        TreeNode(T key, TreeNode leftChild, TreeNode rightChild, TreeNode parent) {
            this.key = key;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

    }

    public void add1(T key) {
        TreeNode<T> parentN = null;
        TreeNode<T> newNode = new TreeNode(key, null, null, null);
        TreeNode<T> pNode = root;
        if (root == null) {
            root = newNode;
            return;
        }
        int c=0;
        while (pNode != null) {
            parentN = pNode;
            c=key.compareTo(pNode.key);
            if (c<0) {
                pNode = pNode.leftChild;
            } else if (c>0) {
                pNode = pNode.rightChild;
            } else {
                return;
            }
        }
        if (key.compareTo(parentN.key)<0) {
            parentN.leftChild = newNode;
            newNode.parent = parentN;
        } else {
            parentN.rightChild = newNode;
            newNode.parent = parentN;
        }

    }



    TreeNode search(TreeNode<T> p, T key) {
        while (p != null && key.compareTo(p.key) != 0) {
            if (key.compareTo(p.key) == -1) p = p.leftChild;
            else p = p.rightChild;
        }
        return p;
    }

    private TreeNode max(TreeNode node) {
        TreeNode p = node;
        while (p.rightChild != null) {
            p = p.rightChild;
        }
        return p;
    }

    TreeNode min(TreeNode node) {
        TreeNode pNode = node;
        while (pNode.leftChild != null) {
            pNode = pNode.leftChild;
        }
        return pNode;
    }

    void remove(TreeNode p) {


        if (p == null) return;
        if (p.leftChild == null && p.rightChild == null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) parentNode.leftChild = null;
            else parentNode.rightChild = null;

        } else if (p.leftChild == null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) {
                parentNode.leftChild = p.rightChild;
                p.rightChild.parent = parentNode;
            } else {
                parentNode.rightChild = p.rightChild;
                p.rightChild.parent = parentNode;
            }

        } else if (p.rightChild == null) {
            TreeNode parentNode = p.parent;
            if (p == parentNode.leftChild) {
                parentNode.leftChild = p.leftChild;
                p.leftChild.parent = parentNode;
            } else {
                parentNode.rightChild = p.leftChild;
                p.leftChild.parent = parentNode;
            }

        } else {
            p.key = max(p.leftChild).key;
            remove(max(p.leftChild));
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p != null && q != null) {
            if (!(p.key == q.key)) {
                return false;
            }
        }
        if (p == null && q == null) {

        } else {
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
