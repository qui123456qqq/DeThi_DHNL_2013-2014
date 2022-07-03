package Ex_2;

public class TamGiacPascal {
    private static int toHop(int n,int k){
        if (k == 0 || k == n) return 1;
        return toHop(n-1,k-1) + toHop(n-1,k);
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print(toHop(i,k) + "\t");
            }
            System.out.println();
        }
    }
}
