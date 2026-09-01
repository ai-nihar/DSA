import java.util.Scanner;

public class contest_q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long m = sc.nextLong();

            long wa=0, wb=0, wc=0;
            long x=m/a;
            long y=m/b;
            long z=m/c;

            long aub=lcm2(a,b);
            long auc=lcm2(a,c);
            long buc=lcm2(b,c);
            long aubuc=lcm3(a,b,c);

            aub=m/aub;
            auc=m/auc;
            buc=m/buc;
            aubuc=m/aubuc;

            wa = aubuc*2 + (aub+auc-2*aubuc)*3 + (x-aub-auc+aubuc)*6;
            wb = aubuc*2 + (aub+buc-2*aubuc)*3 + (y-aub-buc+aubuc)*6;
            wc = aubuc*2 + (buc+auc-2*aubuc)*3 + (z-buc-auc+aubuc)*6;

            System.out.println(wa + " " + wb + " " + wc);
        }
    }

    public static long lcm2(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long lcm3(long a, long b, long c) {
        long lcm = lcm2(a, b);
        return lcm2(lcm, c);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
