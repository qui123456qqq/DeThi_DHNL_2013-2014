package Ex_2;

public class TamGiacPascal {
    private static int toHop(int n,int k){
        if (k == 0 || k == n) return 1;
        return toHop(n-1,k-1) + toHop(n-1,k);
    }
private static void tamGiacPascal() {
        int n = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                int iGT = 1;
                for (int k = 1; k <= i; k++) {
                    iGT = k * iGT;
                }
                int jGT = 1;
                for (int k = 1; k <= j; k++) {
                    jGT = k * jGT;
                }
                int ijGT = 1;
                for (int k = 1; k <= (i - j); k++) {
                    ijGT = k * ijGT;
                }
                int toHop = (iGT / (jGT * ijGT));
                System.out.print(toHop + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                System.out.print(toHop(i,k) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        tamGiacPascal();
    }
}
