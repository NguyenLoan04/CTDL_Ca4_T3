package lab_10;

import java.util.Stack;

public class MyLIFO_App {
    public static <E> void reverse(E[] array) {
        //TODO
        for (int i = 0; i < array.length / 2; i++) {
            E temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static boolean isCorrect(String input) {
        //TODO
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            switch (current) {
                case ']': {
                    if (list.isEmpty() || list.pop() != '[') return false;
                    break;
                }
                case '}': {
                    if (list.isEmpty() || list.pop() != '{') return false;
                    break;
                }
                case ')': {
                    if (list.isEmpty() || list.pop() != '(') return false;
                    break;
                }
                default:
                    list.push(current);
            }
        }
        return list.isEmpty();
    }

    public static int evaluateExpression(String expression) {
        //TODO
        String operandChar = "";
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            Character current = expression.charAt(i);
            if (!isOperator(current)) {
                operandChar += current;
                if (i == expression.length() - 1) {
                    operand.push(Integer.parseInt(operandChar));
                }
            } else {
                if (!operandChar.equals("")) operand.push(Integer.parseInt(operandChar));
                switch (current) {
                    case ')': {
                        while (!operator.peek().equals('(')) {
                            operand.push(calculate(operand.pop(), operator.pop(), operand.pop()));
                        }
                        operator.pop();
                        break;
                    }
                    case '+','-': {
                        if (!operator.isEmpty() && operand.size() > 1 && operator.peek() != '(') {
                            int result = calculate(operand.pop(), operator.pop(), operator.pop());
                            operand.push(result);
                        }
                        operator.push(current);
                        break;
                    }
                    case '*','/':{
                        if(operator.peek().equals('*')|| operator.peek().equals('/')){
                            operand.push(calculate(operand.pop(),operator.pop(),operand.pop()));
                        }
                        operator.push(current);
                        break;
                    }
                    default: operator.push(current);
                }
                operandChar="";
            }
        }
        while (!operator.isEmpty()) {
            operand.push(calculate(operand.pop(), operator.pop(), operand.pop()));
        }
        return operand.pop();
    }

    private static int calculate(int pop, Character pop1, int pop2) {
        switch (pop1) {
            case '+':
                return pop + pop2;
            case '-':
                return pop - pop2;
            case '*':
                return pop * pop2;
            case '/':
                return pop / pop2;
        }
        return 0;
    }

    private static boolean isOperator(Character current) {
        return current == '+' || current == '-' || current == '*' || current == '/' || current == '(' || current == ')';
    }

    public static <E> void print(E[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
//        Integer[] test= new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        reverse(test);
//        print(test);
//        System.out.println(isCorrect("{}{}[()]({})(){}"));
        System.out.println(evaluateExpression("51+(54*(3+2))"));;
    }
}
