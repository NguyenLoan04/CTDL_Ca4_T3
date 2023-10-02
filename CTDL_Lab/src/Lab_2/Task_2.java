package Lab_2;

public class Task_2 {
    public static void drawPyramid(int n){
        drawNextRow(n,0);
    }

    public static void drawNextRow(int n, int k) {
        for(int i=0;i<n-k;i++){
            System.out.print("  ");
        }
        for (int i=0;i<2*k-1;i++){
            System.out.print("* ");
        }
        System.out.println();
        if(n>k){
            drawNextRow(n,k+1);
        }
    }
    // draw Christmas Tree
    public static void drawChristmasTree(int n){
        drawEachPyramid(n,0);
    }

    public static void drawEachPyramid(int n, int k) {
        for (int i=0;i<n-k;i++){
            System.out.print(" ");
        }
        for (int i=0;i<2*k-1;i++){
            drawPyramid(n);
        }
//        System.out.println();
        if(n>k){
            drawEachPyramid(n,k+1);
        }
    }

    public static void main(String[] args) {
//        drawPyramid(3);
        drawChristmasTree(4);
    }
}
