import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class temp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            for(char c:s.toCharArray()) {
                if (c=='(') n++;
                else n--;
            }

            if (n==s.length()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
