package lab_10_Tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public BNode<E> getRight() {
        return right;
    }

    public void setRight(BNode<E> right) {
        this.right = right;
    }

    //add
    public void add(E e) {
        if (this.getData().compareTo(e) > 0) {
            if (this.getLeft() == null) this.setLeft(new BNode<>(e, null, null));
            else this.getLeft().add(e);
        } else {
            if (this.getRight() == null) this.setRight(new BNode<>(e, null, null));
            else this.getRight().add(e);
        }
    }

    public BNode<E> search(BNode<E> root, E node) {
        if (root != null) {
            int compareValue = root.getData().compareTo(node);
            // like binary search
            if (compareValue > 0) return search(root.getLeft(), node);
            else if (compareValue < 0) return search(root.getRight(), node);
            else return root;
        } else return null;
    }

    public int findDepth(BNode<E> node) {
        // if node have 2 child
        if (node.getLeft() != null && node.getRight() != null) {
            return Math.max(1 + findDepth(node.getLeft()), 1 + findDepth(node.getRight()));
        }
        // if node is leaf
        else if (node.getLeft() == null && node.getRight() == null) return 0;
            // if node have 1 child
        else return (node.getLeft() == null) ? 1 + findDepth(node.getRight()) : 1 + findDepth(node.getLeft());
    }

    public int size() {
        return 1 + this.getLeft().size() + this.getRight().size();
    }

    public boolean contains(BNode<E> root, E e) {
        return search(root, e) != null;
    }

    public E findMin(BNode<E> node) {
        return (node.getLeft() == null) ? node.getData() : findMin(node.getLeft());
    }

    public E findMax(BNode<E> root) {
        return (root.getRight() == null) ? root.getData() : findMax(root.getRight());
    }

    public boolean remove(E e) {
        BNode<E> removeNode = search(this, e);
//        if (removeNode == null) return false;
//        else {
            BNode<E> parent = findParents(this, e);
            if (parent == null) {
                BNode<E> newNode = minRight(removeNode.getRight());
                // recreate Successor node
                remove(newNode.getData());
                newNode.setLeft(removeNode.getLeft());
                newNode.setRight(removeNode.getRight());
            }
            else {
                //if Node don't have child
                if (removeNode.getLeft() == null && removeNode.getRight() == null) {
                    if (parent.getData().compareTo(removeNode.getData()) < 0) parent.setRight(null);
                    else parent.setLeft(null);
                }
                //if Node have 1 child
                else if (removeNode.getLeft() == null) parent.setRight(removeNode.getRight());
                else if (removeNode.getRight() == null) parent.setLeft(removeNode.getLeft());
                    // if Node have 2 child
                else {
                    BNode<E> newNode = minRight(removeNode.getRight());
                    // recreate Successor node
                    remove(newNode.getData());
                    newNode.setLeft(removeNode.getLeft());
                    newNode.setRight(removeNode.getRight());
                    // add Successor node
                    if (parent.getData().compareTo(newNode.getData()) < 0) parent.setRight(newNode);
                    else parent.setLeft(newNode);
                }
            }
//        }
        return true;
    }

    private BNode<E> minRight(BNode<E> left) {
        return (left.getLeft() == null) ? left : minRight(left.getLeft());
    }

    private BNode<E> findParents(BNode<E> node, E e) {
        //if Node have 2 child
        if (node.getLeft() != null && node.getRight() != null) {
            if (node.getLeft().getData().compareTo(e) == 0 || node.getRight().getData().compareTo(e) == 0)
                return node;
            else {
                BNode<E> leftVal = findParents(node.getLeft(), e);
                return (leftVal != null) ? leftVal : findParents(node.getRight(), e);
            }
        }
        //if Node have 0 child
        else if (node.getLeft() == null && node.getRight() == null) return null;
            //if Node have 1 child
        else {
            if (node.getLeft() == null) {
                return (node.getRight().getData().compareTo(e) == 0) ? node : findParents(node.getRight(), e);
            } else return (node.getLeft().getData().compareTo(e) == 0) ? node : findParents(node.getLeft(), e);
        }
    }

    public List<E> descendants(BNode<E> root, E data) {
        List<E> result = new ArrayList<>();
        if (root != null) {
            if (root.getData().compareTo(data) == 0){
                if (root.getLeft() != null) {
                    result.add(root.getLeft().getData());
                    result.addAll(descendants(root.getLeft(), data));
                }
                if (root.getRight() != null){
                    result.add(root.getRight().getData());
                    result.addAll(descendants(root.getRight(), data));
                }
            }
            else{
                if (root.getLeft() != null) {
                    result.addAll(descendants(root.getLeft(), data));
                }
                if (root.getRight() != null){
                    result.addAll(descendants(root.getRight(), data));
                }
            }
        }
        return result;
    }

    public List<E> ancestors(BNode<E> root, E e) {
        List<E> result = new ArrayList<>();
        int value = root.getData().compareTo(e);
        if (value != 0) result.add(root.getData());
        if (value > 0 && root.getLeft() != null) {
            result.addAll(ancestors(root.getLeft(), e));
        }
        else if(value<0 && root.getRight()!=null){
            result.addAll(ancestors(root.getRight(),e));
        }
        return result;
    }

    public void printInOrder() {
        if (this.getLeft() != null) this.getLeft().printInOrder();
        System.out.print(this.getData() + " ");
        if (this.getRight() != null) this.getRight().printInOrder();
    }

    public void printPreOrder() {
        System.out.print(this.getData() + " ");
        if (this.getLeft() != null) this.getLeft().printPreOrder();
        if (this.getRight() != null) this.getRight().printPreOrder();
    }

    public void printPostOrder() {
        if (this.getLeft() != null) this.getLeft().printPostOrder();
        if (this.getRight() != null) this.getRight().printPreOrder();
        System.out.print(this.getData() + " ");
    }

    @Override
    public String toString() {
        return "BNode{" +
                "data=" + data
               ;
    }

}
