package com.example.demo;

import java.io.IOException;
import java.util.Scanner;

public class Queen {

    static int[] arr;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0);
        System.out.println(cnt);
    }

    private static void init() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
    }

    public static void dfs(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i = 0 ; i < N; i++) {
            arr[depth] = i;
            if(possible(depth)) {
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col) {
        for(int i = 0 ; i < col ; i++) {
            //행에 일치하는게 있는지 판별
            if(arr[i]==arr[col]) {
                return false;
            }
            //대각선에 일치하는게 있는지 판별
            if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }

        return true;
    }
}
