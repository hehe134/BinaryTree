import java.util.*;


public class BinaryTree<T extends Comparable<T>> extends AbstractSet<T> implements SortedSet<T> {
    TreeNode<T> root = null;
//    private List<TreeNode> nodeList = new ArrayList<TreeNode>();

    public class TreeNode<T> {
        T key;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;
        TreeNode<T> parent;

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
        int c;
        while (pNode != null) {
            parentN = pNode;
            c = key.compareTo(pNode.key);
            if (c < 0) {
                pNode = pNode.leftChild;
            } else if (c > 0) {
                pNode = pNode.rightChild;
            } else {
                return;
            }
        }
        if (key.compareTo(parentN.key) < 0) {
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

    private TreeNode<T> max(TreeNode<T> node) {
        TreeNode<T> p = node;
        while (p.rightChild != null) {
            p = p.rightChild;
        }
        return p;
    }

    TreeNode<T> min(TreeNode<T> node) {
        TreeNode<T> pNode = node;
        while (pNode.leftChild != null) {
            pNode = pNode.leftChild;
        }
        return pNode;
    }

    @Override
    public boolean remove(Object o) {

        TreeNode<T> p = (TreeNode<T>) o;
        if (p == null) return false;
        if (p.leftChild == null && p.rightChild == null) {
            TreeNode<T> parentNode = p.parent;
            if (p == parentNode.leftChild) parentNode.leftChild = null;
            else parentNode.rightChild = null;

        } else if (p.leftChild == null) {
            TreeNode<T> parentNode = p.parent;
            if (p == parentNode.leftChild) {
                parentNode.leftChild = p.rightChild;
                p.rightChild.parent = parentNode;
            } else {
                parentNode.rightChild = p.rightChild;
                p.rightChild.parent = parentNode;
            }

        } else if (p.rightChild == null) {
            TreeNode<T> parentNode = p.parent;
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
        return true;
    }


    public boolean isSameTree(TreeNode<T> p, TreeNode<T> q) {
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

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T last() {
        return null;
    }
}
