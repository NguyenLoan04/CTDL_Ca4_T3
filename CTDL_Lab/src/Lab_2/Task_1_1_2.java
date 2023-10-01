package Lab_2;

public class Task_1_1_2 {
    public static int getSn1(int n){
        //TO DO
        if(n==1) return 1;
        return  (int) (Math.pow(-1,n+1)*n) + getSn1(n-1);
    }
    public static int getSn2(int n){
        if(n==1) return 1;
        return (n * giaiThua(n-1)) + getSn2(n-1);
    }

    private static int giaiThua(int i) {
        if(i==1) return 1;
        return i*giaiThua(i-1);
    }
    public static int getSn3(int n){
        if(n==1) return (int) Math.pow(1,2);
        return (int) Math.pow(n,2)+ getSn3(n-1);
    }
    //
    public static double getSn4(int n){
        if(n==0) return 1;
        return (1/mau(n)) +getSn4(n-1);
    }

    private static double mau(int i) {
        if(i==1) return 2;
        return  2*i *mau(i-1);
    }
    public int getFibonacci(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else{
            return getFibonacci(n-1)+ getFibonacci(n-2);
        }
    }

    public static void main(String[] args) {
//        System.out.println(getSn1(3));
//        System.out.println(getSn2(3));
//        System.out.println(getSn3(3));
        System.out.println(getSn4(2));
//        System.out.println(mau(2));
    }
}
