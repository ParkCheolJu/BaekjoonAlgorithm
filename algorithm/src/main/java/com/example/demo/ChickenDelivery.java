package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ChickenDelivery {
    static int N, M;
    static List<Location> house;
    static List<Location> chicken;
    static int minChickenDistance;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        init();
        DFS(0, 0);
        System.out.println(minChickenDistance);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) house.add(new Location(i, j));
                if (temp == 2) chicken.add(new Location(i, j));
            }
        }

        minChickenDistance = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
    }

    private static void DFS(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        temp = Math.min(temp, getDistance(house.get(i).x, house.get(i).y, chicken.get(j).x, chicken.get(j).y));
                    }
                    System.out.println(temp);
                }

                res += temp;
            }
            minChickenDistance = Math.min(minChickenDistance, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    public static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

