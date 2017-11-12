import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {
    BinaryTree<Integer> bst = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };
    BinaryTree bst1 = new BinaryTree() {
        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator comparator() {
            return null;
        }

        @Override
        public SortedSet subSet(Object fromElement, Object toElement) {
            return null;
        }

        @Override
        public SortedSet headSet(Object toElement) {
            return null;
        }

        @Override
        public SortedSet tailSet(Object fromElement) {
            return null;
        }

        @Override
        public Object first() {
            return null;
        }

        @Override
        public Object last() {
            return null;
        }
    };
    BinaryTree<Integer> bst2 = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };
    BinaryTree<Integer> bst2t = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };
    BinaryTree<Integer> bst2t1 = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };
    BinaryTree<Integer> bst3 = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };
    BinaryTree<Integer> bst3t = new BinaryTree<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Comparator<? super Integer> comparator() {
            return null;
        }

        @Override
        public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> headSet(Integer toElement) {
            return null;
        }

        @Override
        public SortedSet<Integer> tailSet(Integer fromElement) {
            return null;
        }

        @Override
        public Integer first() {
            return null;
        }

        @Override
        public Integer last() {
            return null;
        }
    };

    @Test
    void remove() {

        bst.add1(18);
        bst.add1(6);
        bst.add1(3);

        bst1.add1(18);
        bst1.add1(3);
        bst.remove(bst.search(bst.root, 6));
        assertTrue(bst.isSameTree(bst.root, bst1.root)); //bst:18,6,3->18,3


        bst2.add1(8);
        bst2.add1(9);
        bst2.add1(10);

        bst2t.add1(8);
        bst2t.add1(10);

        bst2.remove(bst.search(bst2.root, 9));
        assertTrue(bst.isSameTree(bst2.root, bst2t.root));//bst2:8,9,10->8,10


        bst2t1.add1(8);

        bst2.remove(bst.search(bst2.root, 10));
        assertTrue(bst2.isSameTree(bst2.root, bst2t1.root));//bst2:8,10 -> 8


        bst3.add1(8);
        bst3.add1(4);
        bst3.add1(10);
        bst3.add1(2);
        bst3.add1(6);
        bst3.add1(1);
        bst3.add1(3);


        bst3t.add1(8);
        bst3t.add1(3);
        bst3t.add1(10);
        bst3t.add1(2);
        bst3t.add1(6);
        bst3t.add1(1);

        bst3.remove(bst3.search(bst3.root, 4));
        assertTrue(bst3.isSameTree(bst3.root, bst3t.root));
//           8                                     8
//          /  \                                  / \
//        4     10                               3  10
//       /  \                                   / \
//      2    6                                 2   6
//     / \                        ->          / \
//    1   3                                  1
    }

}