package lab_3;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    //iterativeLinearSearch
    public int iterativeLinearSearch(int target) {
        //TO DO
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    //recursiveLinearSearch
    public int recursiveLinearSearch(int target) {
        return recursiveLinearSearch1(array.length, target);
    }

    public int recursiveLinearSearch1(int size, int target) {
        if (size == 0) return -1;
        if (array[size - 1] == target) return size - 1;
        return recursiveLinearSearch1(size - 1, target);
    }

    //iterativeBinarySearch
    public int iterativeBinarySearch(int target) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == array[mid]) return mid;
            else if (target < array[mid])
                high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    //recursiveBinarySearch
    public int recursiveBinarySearch(int target) {
        Arrays.sort(array);
        return recursiveBinarySearch1(0, array.length - 1, target);
    }

    private int recursiveBinarySearch1(int low, int high, int target) {
        Arrays.sort(array);
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target == array[mid]) return mid;
        else if (target < array[mid]) {
            return recursiveBinarySearch1(low, mid - 1, target);
        } else return recursiveBinarySearch1(mid + 1, high, target);
    }


//

    public static void main(String[] args) {
        MyArray test = new MyArray(new int[]{12, 10, 9, 45, 2, 10, 10, 45});
//        System.out.println(test.iterativeLinearSearch(45));
//        System.out.println(test.recursiveLinearSearch(15));
        System.out.println(test.recursiveBinarySearch(9));
    }
}
