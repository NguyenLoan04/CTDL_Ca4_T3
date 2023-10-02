package Lab_1;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    // mirror()
    public int[] mirror() {
        int[] result = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
            result[i + array.length] = array[array.length - 1 - i];
        }
        return result;
    }

    //removeDuplicate(int[] arr)
    public int[] removeDuplicate() {
        int n = array.length;
        int count = 0;
        int[] result = array.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    result = delete(result, j - count);
                    count++;
//                    break;
//                    print(array);
                }
            }
        }
        System.out.println(count);
        int[] re = new int[n - count];
        for (int i = 0; i < re.length; i++) {
            re[i] = result[i];
        }
        return re;
    }

    //
    public int[] removeDuplicate(int[] array) {
        int oldLength = array.length;
        int conflic = 0;
        for (int i = 0; i < oldLength; i++) {
            for (int j = i + 1; j < oldLength; j++) {
                if (array[i] == array[j]) {
                    conflic++;
                    break;
                }
            }
        }
        int newLength = oldLength - conflic;
        int[] result = new int[newLength];
        int a = 0;
        for (int i = 0; i < oldLength; i++) {
            boolean flag = false;
            for (int j = 0; j < newLength; j++) {
                if (array[i] == result[j]) {
                    flag = true;
                    a++;
                    break;
                }
            }
            if (!flag) {
                result[i - a] = array[i];
            }
        }
        return result;
    }

    public static int[] delete(int[] arr, int index) {
//        print(arr);
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        return arr;
    }

    // getMissingNumber
    public int[] getMissingValues() {
        int count = 0;
        int missNum = 0;
        int[] temp = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i-1] > 1) {
                missNum = array[i]-1;
                temp[i] = missNum;
                count++;
            }

        }
        print(temp);
//        System.out.println();
        int[] result = new int[count];
        int a = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (temp[i] == 0) {
                    a++;
                    break;
                }
                result[i - a] = temp[i];
            }

        }
        return result;
    }

    //     fillMissingValues
    public int[] fillMissingValues(int k) {
        int[] listIndex = new int[array.length];
        int cursor = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) { // lưu vị trí cần thay thế vào 1 mảng mới
                listIndex[cursor++] = i;
                if (i < k || array.length - k <= i) {
                    // nếu i nhỏ hơn k hoặc chiều dài mảng trừ k không đủ xét cho i thì
                    // không làm gì
                } else {
                    int sum = 0;
                    for (int j = 1; j < k / 2 + 1; j++) {
                        sum += array[i - j];
                        sum += array[i + j];
                    }
                    if (k % 2 == 1) { // TH k=3
                        // nếu arr[1] > arr[5] thì sum=sum+arr[5]
                        if (array[i - k / 2 - 1] > array[i + k / 2 + 1] || array[i + k / 2 + 1] > 0) {
                            sum += array[i + k / 2 + 1];
                            // nếu index của listIndex tồn tại bằng i-k/2-1 thì cộng thêm ở vị trí đó
                        } else if (indexOf(listIndex, i - k / 2 - 1) != -1 && i - k / 2 - 1 != -1) {
                            sum += array[i + k / 2 + 1];
                        }
                        // cộng ở đằng trước i
                        else sum += array[i - k / 2 - 1];
                    }
                    // chia trung bình cộng
                    sum /= k;
                    array[i] = sum;
                }
            }
        }
        return array;
    }

    private int indexOf(int[] arr, int checkValue) {
        for (int i = 0; i < arr.length; i++) {
            if (checkValue == array[i]) {
                return i;
            }
        }
        return -1;
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        MyArray test = new MyArray(new int[]{10, 11, 12, -1, 14, 10, 17, 19, 20});
//        print(test.mirror());
//        print(delete(test.array, 5));
//        test.removeDuplicate(new int[]{1, 3, 5, 5, 6, 7, 6, 7,5,23,1,5});
//        print(test.getMissingValues());
        print(test.fillMissingValues(3));

//        print(test.removeDuplicate());
    }

}
