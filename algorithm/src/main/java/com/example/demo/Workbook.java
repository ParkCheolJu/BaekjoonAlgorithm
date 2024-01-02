package com.example.demo;

import java.io.*;
import java.util.*;

public class Workbook {

    static int n,m;
    static List<Integer>[] pList;
    static int[] lock;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        init();
        bfs();
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pList = new ArrayList[n+1];

        lock = new int[n+1];
        for(int i=1; i<n+1; i++) {
            pList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            pList[fst].add(sec);
            lock[sec]++;
        }
    }

    static void bfs() {
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<n+1; i++) {
            if(lock[i]==0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int pos = q.poll();
            unlock(pos);
            sb.append(pos+" ");

            for(int next : pList[pos]) {
                if(lock[next] ==0) {
                    q.add(next);
                }
            }
        }
    }

    static void unlock(int num) {
        for(int unlock : pList[num]) {
            lock[unlock]--;
        }
    }
}
