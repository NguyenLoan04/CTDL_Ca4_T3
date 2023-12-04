package lab_10_Tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    public void add(E e) {
        //TODO
        if (root == null) this.root = new BNode<>(e, null, null);
        else root.add(e);
    }


    public void add(Collection<E> col) {
        //TODO
        for (E element : col) {
            add(element);
        }
    }

    public int depth(E node) {
        //TODO
        BNode<E> currentNode = this.root.search(this.root, node);
        return (currentNode != null) ? currentNode.findDepth(currentNode) : -1;
    }


    private BNode<E> search(BNode<E> root, E node) {
        if (root == null) return null;
        else return root.search(this.root, node);
    }

    public int height() {
        return root.findDepth(root);
    }

    public int size() {
        //TODO
        if (root == null) return 0;
        else return root.size();
    }

    public boolean contains(E e) {
        //TODO
        return this.root.contains(root, e);
    }

    public E findMin() {
        //TODO
        return this.root.findMin(root);
    }


    public E findMax() {
        //TODO
        return this.root.findMax(root);
    }

    public boolean remove(E e) {
        //TODO
        if(root==null) return false;
        else return this.root.remove(e);
    }

    public List<E> descendants(E data) {
        //TODO
        if(root==null) return null;
        else return this.root.descendants(this.root, data);
    }

    public List<E> ancestors(E data) {
        //TODO
        if(root==null) return null;
        return this.root.ancestors(this.root, data);
    }

    public void inOrder() {
        this.root.printInOrder();
    }

    public void preOrder() {
        this.root.printPreOrder();
    }

    public void postOrder() {
        this.root.printPostOrder();
    }

    public static void main(String[] args) {
        BST<Integer> test=new BST<>();
        test.add(12);
        test.add(13);
        test.add(24);
        test.add(11);
        test.add(9);
        test.add(102);
        test.add(1);
        test.add(2);
        test.add(5);
        test.add(17);
        test.add(26);
        test.add(20);
        test.add(23);
        test.add(34);
        test.add(16);
        test.add(21);
        System.out.println(test.contains(24));
        System.out.println(test.root);
        System.out.println(test.remove(5));
        test.preOrder();
        System.out.println();
        test.inOrder();
        System.out.println();
        System.out.println(Arrays.toString(test.descendants(26).toArray()));
    }
}
