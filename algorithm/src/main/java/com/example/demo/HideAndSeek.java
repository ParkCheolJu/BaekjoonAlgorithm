package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

    private static final int MAX = 100_001;
//    private static final int MAX = 200_000;
    private static int y;
    private static Queue<Integer> queue;
    private static int[] dist;
    private static boolean[] visit;

    public static void main(String[] args) {
        init();
        BFS();
        System.out.println(dist[y]);
    }

    private static void init(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        y = sc.nextInt();
        queue = new LinkedList<>();
        dist = new int[MAX];
        visit = new boolean[MAX];
        queue.add(x);
    }

    private static void BFS(){

        while (!queue.isEmpty()) {
            int k = queue.remove();
            if (k == y) {
                break;
            }

            int temp = k + 1;
            if (temp < MAX && !visit[temp]) {
                saveDist(temp, k);
            }

            temp = k - 1;
            if (temp >= 0 && !visit[temp]) {
                saveDist(temp, k);
            }

            temp = 2 * k;
            if (temp < MAX && !visit[temp]) {
                saveDist(temp, k);
            }
        }
    }

    private static void saveDist(int after, int before){
        visit[after] = true;
        queue.add(after);
        dist[after] = dist[before] + 1;
    }
}
