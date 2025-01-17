import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int sticker[][];
    static int dp[][];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n+1];
            dp = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            int max = 0;

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + sticker[1][i];
            }


            max = Math.max(dp[0][n], dp[1][n]);
            sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}