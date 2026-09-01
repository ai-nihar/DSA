import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class demo_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[] nck = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] monsters = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < monsters.length; j++) {
                if (monsters[j]==nck[1]){
                    nck[1]*=2;
                    monsters[j]=-1;
                } else if (monsters[j]<nck[1]) {
                    if (nck[2]>0) {
                        if (nck[2]>=nck[1]-monsters[j]) {
                            nck[2]-=(nck[1]-monsters[j]);
                            nck[1]*=2;
                        } else {
                            nck[1]+=(nck[2]+monsters[j]);
                            nck[2]=0;
                        }
                        monsters[j]=-1;
                    } else {
                        nck[1]+=monsters[j];
                    }
                } else {
                    continue;
                }
            }

            
        }
    }
}
