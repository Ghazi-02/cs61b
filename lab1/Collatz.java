/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** Calculates nextNumber by checking whether n is even. If True then divide n by 2. Otherwise
     * multiply n by 3 and add 1 */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n /2;
        }else {
            return 3*n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

