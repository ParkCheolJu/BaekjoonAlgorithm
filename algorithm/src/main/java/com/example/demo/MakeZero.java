package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeZero {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 1; i <= temp; i++) {
            n = Integer.parseInt(br.readLine());
            sb.setLength(0);
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);
        }
    }

    private static void dfs(int index, int num, int sum, int op, String str) {
        if (index == n) {
            sum += num * op;
            if (sum == 0) sb.append(str).append("\n");
            return;
        }

        dfs(index + 1, num * 10 + index + 1, sum, op, str + " " + (index + 1));
        dfs(index + 1, index + 1, sum + num * op, 1, str + "+" + (index + 1));
        dfs(index + 1, index + 1, sum + num * op, -1, str + "-" + (index + 1));
    }
}
