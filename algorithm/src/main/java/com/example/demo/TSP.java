package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP {

    private static int n;
    private static boolean[] visited;
    private static int[][] map;
    private static long result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 0);
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void dfs(int start, int now, long cost) {
        if (isFinished()) {
            if (map[now][start] != 0) {
                result = Math.min(result, cost + map[now][0]);
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + map[now][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isFinished() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
