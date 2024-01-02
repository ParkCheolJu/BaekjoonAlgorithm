package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Box {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {

        init();
        System.out.println(DP());
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[N];
        Arrays.fill(dp, 1);
    }
    
    private static int DP(){
        int result = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(dp[i], result);
        }
        
        return result;
    }
}

