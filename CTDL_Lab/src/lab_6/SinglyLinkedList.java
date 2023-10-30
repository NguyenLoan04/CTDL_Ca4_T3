package lab_6;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    int size;

    public SinglyLinkedList() {
    }

    //
    public int size() {
        return size;
    }

    //
    public boolean isEmpty() {
        return size == 0;
    }

    //
    public E first() {
        if (head == null) return null;
        else return head.getData();
    }

    //
    public E last() {
        if (size() == 0) return null;
        else return tail.getData();
    }

    //
    public void addFirst(E a) {
        Node<E> node = new Node<>(a, null);
        if (head == null) head = tail = node;
        else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    //
    public void addLast(E a) {
        Node<E> node = new Node<>(a, null);
        if (head == null) addFirst(a);
        else {
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    //
    public E removeFirst() {
        if(head==null) return null;
        else if(head==tail){
            E h= head.getData();
            head=tail=null;
            size--;
            return h;
        }
        else{
            E h= head.getData();
            head=head.getNext();
            size--;
            return h;
        }
    }
    //
    public E removeLast(){
        if(head==null) return null;
        else if(head==tail){
            E t= tail.getData();
            head=tail=null;
            size--;
            return t;
        }
        else{
            Node<E> temp= head;
            while (temp.getNext().getNext()!=null){
                temp=temp.getNext();
            }
            E t= tail.getData();
//            temp.setNext(temp.getNext().getNext());
            temp.setNext(null);
            tail=temp;
            size--;
            return t;
        }
    }
    //
    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData());
                temp = temp.getNext();
                if (temp != null) {
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.addFirst(5);
        test.addFirst(4);
        test.addLast(3);
        test.addLast(7);
        test.removeLast();
        printLinkedList(test.head);

    }
}
