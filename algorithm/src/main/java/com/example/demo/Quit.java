package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit {

    static int[] T;
    static int[] P;
    static int[] dp;

    static int N;

    public static void main(String[] args) throws IOException {
        init();
        dp();

        System.out.println(dp[0]);
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dp(){
        for (int i = N - 1; i >= 0; i--) {
            int next = i + T[i];

            if (next > N) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[next]);
            }
        }
    }
}

