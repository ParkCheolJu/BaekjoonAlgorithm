package com.example.demo;

import java.util.Scanner;

public class BeOne {

    static int x;
    static int[] dp;
    static int[] before;

    public static void main(String[] args){
        init();
        DP();

        System.out.println(dp[x]);

        StringBuilder str = new StringBuilder();
        while(x > 0){
            str.append(x).append(" ");
            x = before[x];
        }

        System.out.print(str);
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        dp = new int[x + 1];
        before = new int[x + 1];
        dp[1] = 0;
    }

    private static void DP(){
        for(int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
        }
    }
}

