package lab_4;

import java.util.Arrays;

public class Task_2 {
    //MergeSort
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;
        return mergeSort1(array, 0, array.length - 1);
    }

    private static int[] mergeSort1(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(array, left, mid);
            mergeSort1(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        return array;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //
        int l = mid - left + 1;
        int r = right - mid;
        //
        int[] leftArray = new int[l];
        int[] rightArray = new int[r];
        //
        for (int i = 0; i < l; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < r; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        //
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < l && j < r) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < l) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < r) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // sort by ascending order
    public static int[] quickSort(int[] array) {
        // TODO
        return quickSortSupport(array, 0, array.length - 1);

    }

    private static int[] quickSortSupport(int[] array, int low, int high) {
        if (low > high){ return array;}
        int pivot= getPivot_Last(array);
        int left=low;
        int right=high;
        while (left<right){
            while (array[left]<=pivot && left<right){
                left++;
            }
            while (array[right]>=pivot && left<right){
                right--;
            }
            swap(array,left,right);
        }
            swap(array,left,high);
            quickSortSupport(array, low, left -1);
            quickSortSupport(array, left + 1, high);
            return array;
    }



    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    // select pivot element based on the last element in
    //the array

    private static int getPivot_Last(int[] array) {
        // TODO
        return array[array.length - 1];
    }


    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] test = {3, 5, 1, 7, 13, 24, 29, 39, 31, 11, 23};
        int[] test2={56,32,11,89,100,10,23,17,69,59,70,88};
//        System.out.print(Arrays.toString(mergeSort(test)));
        print(quickSort(test2));
    }
}
