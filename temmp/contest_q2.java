import java.util.Scanner;

public class contest_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(ans(arr));
        }
    }

    public static int ans(int[] arr) {
        int max = arr[0];
        int chagesCount=1;
        for (int i = 1; i < arr.length; i++) {
            if (max<=arr[i]) {
                max=arr[i];
                chagesCount++;
            }
        }
        return chagesCount;
    }
}
