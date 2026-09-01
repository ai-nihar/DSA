import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class demo_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int x =Integer.parseInt(st.nextToken());
                    map.put(x, map.getOrDefault(x,0)+1);
                    if (map.getOrDefault(x,0)>(n-1)*2) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if (flag) System.out.println("YES");
        }
    }
}
