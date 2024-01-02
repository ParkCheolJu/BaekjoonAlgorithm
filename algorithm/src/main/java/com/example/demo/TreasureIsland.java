package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland {

    static int n, m;

    static int[][] map;

    static boolean[][] check;

    static int[] dx = {-1, 1, 0, 0};

    static int[] dy = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        init();
        calMaxDistance();

        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if ("W".equals(line[0]))
                    map[i][j] = -1;
                else
                    map[i][j] = 1;
            }
        }
    }

    private static void calMaxDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    check = new boolean[n][m];
                    max = Math.max(max, bfs(j, i));
                }
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int maxMove = Integer.MIN_VALUE;

        check[y][x] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];
            int move = pos[2];

            if (move > maxMove) {
                maxMove = move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;

                if (!check[ny][nx] && map[ny][nx] == 1) {
                    check[ny][nx] = true;
                    q.add(new int[]{nx, ny, move + 1});
                }
            }
        }

        return maxMove;

    }
}
