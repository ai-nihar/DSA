import java.util.*;

public class c1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }

            // case 1: don't use special move
            boolean winNormal = (sum % 2 == 1);

            // case 2: use special move
            boolean winSpecial = ((n * k) % 2 == 0);

            if (winNormal || winSpecial)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}