package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RedGreenColorWeakness {
    static int N;
    static char[][] arr;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        init();

        int normal = searchArea();
        beRedGreenColorWeakness();
        int redGreenColorWeakness = searchArea();

        System.out.println(normal + " " + redGreenColorWeakness);

    }

    public static void init(){
        String str;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            arr = new char[N + 1][N + 1];
            isVisited = new boolean[N + 1][N + 1];

            for (int i = 0; i < N; i++) {
                str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
        } catch(Exception ignore){}
    }

    public static int searchArea(){
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true;
        char tmp_char = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (new_x < 0 || new_y < 0 || new_x > N || new_y > N) {
                continue;
            }

            if (!isVisited[new_x][new_y] && arr[new_x][new_y] == tmp_char) {
                dfs(new_x, new_y);
            }
        }
    }

    public static void beRedGreenColorWeakness(){
        isVisited = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
    }
}
