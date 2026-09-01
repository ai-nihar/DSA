import java.util.Scanner;

public class contest_q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            char[] s = sc.next().toCharArray();
            int ans = 1;
            for (int j = 1; j < n; j++) {
                ans++;
                if (s[j]=='L') break;
            }
            System.out.println(ans);
        }
    }
}
