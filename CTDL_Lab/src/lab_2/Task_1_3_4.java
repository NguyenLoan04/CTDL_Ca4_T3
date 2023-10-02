package Lab_2;

public class Task_1_3_4 {
    public static void printTrianglePascal(int row){
            for(int i=1;i<=row;i++){
                for (int j=0;j<row-i;j++){
                    System.out.print(" ");
                }
                print(getPascalTriangle(i));
                System.out.println();
            }

    }
    public static void print(int[] ar){
        for (int i=0;i<ar.length;i++){
            System.out.print(ar[i]+ " ");
        }
    }
    public static int[] getPascalTriangle(int n){
        if(n==1) return new int[]{1};
        else{
           int[] prev= getPascalTriangle(n-1);
           return generateNextRow(prev);
        }
    }
    public static int[] generateNextRow(int[] preRow){
        int[] nextRow= new int[preRow.length+1];
        nextRow[0]=nextRow[nextRow.length-1]=1;
        for(int i=1;i<preRow.length;i++){
            nextRow[i]=preRow[i-1]+preRow[i];
        }
        return nextRow;
    }
    // Tower of Hanoi
    public static void moveTower(int n,String from_rod, String to_rod, String help_rod){
        if(n==1) System.out.println("Take disk 1 from rod:"+from_rod+ " to rod:"+ to_rod);
        else{
            moveTower(n-1,from_rod,help_rod,to_rod);
            System.out.println("Take disk "+ n+" from rod "+from_rod+" to rod "+ to_rod);
            moveTower(n-1,help_rod,to_rod,from_rod);
        }
    }

    public static void main(String[] args) {
        printTrianglePascal(4);
    }
}
