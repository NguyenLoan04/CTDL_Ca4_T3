package lab_10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
    public static <E> void stutter(Queue<E> input){
        //TODO
        Queue<E> temp = new LinkedList<>();
        while (!input.isEmpty()) {
            temp.add(input.peek());
            temp.add(input.poll());
        }
        input.addAll(temp);
    }
    public static <E> void mirror(Queue<E> input){
        //TODO
        Queue<E> backup= new LinkedList<>();
        Stack<E> stack= new Stack<>();
        while (!input.isEmpty()){
            backup.add(input.peek());
            stack.push(input.poll());
        }
        while (!stack.isEmpty()){
            backup.add(stack.pop());
        }
        input.addAll(backup);
        System.out.println(Arrays.toString(input.toArray()));
    }

    public static void main(String[] args) {
        Queue<String> test= new LinkedList<>();
        test.add("a");
        test.add("b");
        test.add("c");
        mirror(test);
    }
}
