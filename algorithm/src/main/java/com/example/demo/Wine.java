package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine {

    private static int N;
    private static int[] wines;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        init();
        DP();
        System.out.println(dp[N - 1]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        wines = new int[N];
        for (int i = 0; i < N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void DP() {
        dp = new int[N];
        dp[0] = wines[0];

        if (N > 1)
            dp[1] = wines[0] + wines[1];

        if (N > 2)
            dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));


        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }
    }
}
