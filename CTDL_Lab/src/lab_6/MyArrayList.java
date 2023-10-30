package lab_6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = (E[]) new Object[capacity];
    }

    public void growSize() {
        int cap = elements.length + elements.length / 2 + 1;
        E[] temp = (E[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) {
        if (i > 0 && i < size) {
            return elements[i];
        }
        throw new IndexOutOfBoundsException("Ừm hứm");
    }

    public E set(int i, E e) {
        if (i < 0 || i > size) throw new IndexOutOfBoundsException("Ừm hứm");
        elements[i] = e;
        return elements[i];
    }

    public boolean add(E e) {
        if (size > elements.length * 0.8f) {
            growSize();
            elements[size] = e;
            size++;
        }
        return true;
    }

    public void add(int i, E e) {
        if (i < 0 || i >=size) throw new IndexOutOfBoundsException("Ừm hứm");
        else if (i == 0){
            for (int index=size;index>=i;index--){
                elements[index]=elements[index-1];
            }
            elements[i]=e;
            size++;
        }
        else if (i == size-1) add(e);
        else {
            for (int index = size; index >= i; index--) {
                elements[index] = elements[index - 1];
            }
            elements[i] = e;
            size++;
        }
    }
    // remove at index i
    public E remove(int i) {
        if (i < 0 || i >=size)
            throw new IndexOutOfBoundsException("Ừm hứm");
        else {
            for (int index = 0; index < size; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size] = null;
            size--;
            return elements[i];
        }
    }
    // remove
    public E remove(){
        return remove(size-1);
    }
    //clear
    public void clear(){
        for (int i=0;i<size;i++){
            elements[i]=null;
            size--;
        }
    }
    // contains
    public boolean contains(E a){
        return indexOf(a)>=0;
    }
    //indexOf(E a)
    public int indexOf(E a){
        if(isEmpty()) return -1;
        else{
           for (int i=0;i<size;i++){
               if(a.equals(elements[i])) return i;
           }
        }
        return -1;
    }

    //
    public int lastIndexOf(E a){
        if(isEmpty()) return -1;
        else {
            for (int i=size-1;i>=0;i--){
                if (a.equals(elements[i])) return i;
            }
        }
        return -1;
    }
    //
    public E[] toArray(){
      E[] temp= (E[]) new Object[size];
      for (int i=0;i<size;i++){
          temp[i]=elements[i];
      }
        return temp;
    }
    //
    public MyArrayList<E> clone(){
        MyArrayList<E> temp= new MyArrayList<>();
        temp.elements=elements.clone();
        temp.size=size;
        return temp;
    }
    // remove(E a)
    public boolean remove(E a){
        if(contains(a)) remove(indexOf(a));
        return false;
    }
    // sort(Comparator)
    public void sort(Comparator<E> c){
//        Arrays.sort(elements,c);
        // nếu mảng chứa null không sắp xếp dc
        Arrays.sort(elements,0,size-1,c);
    }


}
