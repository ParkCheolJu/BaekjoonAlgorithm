package com.example.demo;

import java.util.*;

public class Kruskal {
     static int n;
     static int m;
     static int[][] graph;
     static int[] parent;
     static int final_cost;



    public static void main(String[] args) {

        init();
        int total = 0;

        for (int i = 0; i < m; i++) {
            total += graph[i][2];
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
            }
        }

        System.out.println(total - final_cost);
    }

    private static void init(){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[m][3];
        for (int i = 0; i < 5; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(graph, (o1, o2) -> o2[2] > o1[2] ? 1 : -1);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        final_cost = 0;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}
