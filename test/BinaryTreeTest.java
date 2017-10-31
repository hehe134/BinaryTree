import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

    @Test
    void remove() {
        int[] keys = new int[]{15, 6, 18, 3, 7, 13, 20, 2, 9, 4};
        BinaryTree bst = new BinaryTree();
        bst = bst.getTree(keys);

        int[] keys1 = new int[]{15, 6, 3, 7, 13, 20, 2, 9, 4};
        BinaryTree bst1 = new BinaryTree();
        bst1 = bst1.getTree(keys1);
        bst.remove(bst.search(18));
        assertTrue(new BinaryTree().isSameTree(bst.root, bst1.root));

        int[] keys2 = new int[]{15, 6, 3, 7, 13, 2, 9, 4};
        BinaryTree bst2 = new BinaryTree();
        bst2 = bst2.getTree(keys2);
        bst.remove(bst.search(20));
        assertTrue(new BinaryTree().isSameTree(bst.root, bst2.root));

        int[] keys3 = new int[]{15, 6, 3, 13, 2, 9, 4};
        BinaryTree bst3 = new BinaryTree();
        bst3 = bst3.getTree(keys3);
        bst.remove(bst.search(7));
        assertTrue(new BinaryTree().isSameTree(bst.root, bst3.root));

        int[] keys4 = new int[]{15, 6, 3, 7, 13, 2, 4};
        BinaryTree bst4 = new BinaryTree();
        bst4 = bst4.getTree(keys4);
        assertFalse(new BinaryTree().isSameTree(bst.root, bst4.root));

        int[] keys_0 = new int[]{42, 15, 45, 3, 16, 13, 20, 33, 9, 55, 24};
        BinaryTree bst_0 = new BinaryTree();
        bst_0 = bst_0.getTree(keys_0);

        int[] keys_1 = new int[]{42, 15, 45, 3, 16, 13, 20, 9, 55, 24};
        BinaryTree bst_1 = new BinaryTree();
        bst_1 = bst_1.getTree(keys_1);
        bst_0.remove(bst_0.search(33));
        assertTrue(new BinaryTree().isSameTree(bst_0.root, bst_1.root));

    }

}