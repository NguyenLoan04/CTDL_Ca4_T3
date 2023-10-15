package lab_4;

public class Task_1 {
    //selectionSort
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            // max=6
//            if (max != i) {
                swap(array, max, i);
//            }
        }
        return array;
    }
    //bubbleSort
    public static int[] bubbleSort(int[] array){
        for (int i=0;i< array.length-1;i++){
            // tạo biến cho biết khi nào không còn phần tử để swap(phần tử cuối)
            boolean stopped=true;
            for (int j=0;j<array.length-1-i;j++){
                if(array[j]< array[j+1]){
                    swap(array,j,j+1);
                    stopped=false;
                }
            }
            if(stopped) break;
        }

        return array;
    }
    //insertionSort
    public static int[] insertionSort(int[] array){
        for (int i=1;i< array.length;i++){
            int cur= array[i];
            int j=i;
            while (j>0 && array[j-1]<cur){
                array[j]=array[j-1];
                j--;
            }
            array[j]=cur;
        }
        return array;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] test = {3, 4, 9, 8, 12, 13, 31, 29};
//        print(selectionSort(test));
//        print(bubbleSort(test));
        print(insertionSort(test));
    }
}
