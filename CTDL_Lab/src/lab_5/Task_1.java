package lab_5;

public class Task_1 {
    // add
    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length) return null;
        else {
            int[][] result = new int[a.length][a[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = a[i][j] + b[i][j];
                }
            }
            return result;
        }
    }

    // subtract
    public static int[][] subtract(int[][] a, int[][] b) {
        if (a.length != b.length) return null;
        else {
            int[][] result = new int[a.length][a[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = a[i][j] - b[i][j];
                }
            }
            return result;
        }
    }

    // multiply
    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) return null;
        else {
            int[][] result = new int[a.length][b[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < b.length; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return result;
        }
    }
    // transpose
    public static int[][] transpose(int[][] a){
        int[][] result= new int[a[0].length][a.length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                result[j][i]= a[i][j];
            }
        }
        return result;
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{7, 2}, {5, 3}};
        int[][] b = {{2, 1}, {3, 1}};
//        printMatrix(add(a,b));
//        printMatrix(subtract(a, b));
        printMatrix(transpose(a));
    }
}
