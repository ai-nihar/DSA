import java.util.*;

public class C2 {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (gcd(a, n) == 1 && gcd(b, m) == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}