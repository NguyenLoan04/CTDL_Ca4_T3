package lab_10_Tree;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> test=new BST<>();
        test.add(12);
        test.add(14);
        test.add(10);
        test.add(24);
        test.add(13);
        test.add(11);
        test.add(8);
        test.add(9);
        test.add(7);
        test.add(23);
        test.add(25);
//        test.remove(12);
        test.preOrder();
        System.out.println();
        test.inOrder();
        System.out.println();
    }
}
