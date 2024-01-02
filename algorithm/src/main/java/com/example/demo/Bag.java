package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bag {

    static int n, maxWeight;
    static int[][] dp, item;


    public static void main(String[] args) throws IOException {
        init();
        DP();


        Arrays.stream(dp).forEach(item -> {
            for(int i : item){
                System.out.print(i + " ");
            }
            System.out.println();
        });

        System.out.println(dp[n][maxWeight]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        maxWeight = Integer.parseInt(inputs[1]);

        item = new int[n + 1][2];  // weight, value

        for (int i = 1; i <= n; i++) {
            inputs = br.readLine().split(" ");
            item[i][0] = Integer.parseInt(inputs[0]);
            item[i][1] = Integer.parseInt(inputs[1]);
        }

        dp = new int[n + 1][maxWeight + 1];
    }

    private static void DP() {
        for (int k = 1; k <= maxWeight; k++) {
            for (int i = 1; i <= n; i++) {
                dp[i][k] = dp[i - 1][k];
                if (k - item[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);
                }
            }
        }
    }
}

