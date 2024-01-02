package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LineUp {

    static int n;
    static int m;
    static LinkedList<Integer>[] linkedListArray;
    static int[] inDegree;

    public static void main(String[] args) {
        init();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                inDegree[i]--;
                System.out.print(i + " ");
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            LinkedList<Integer> l = linkedListArray[num];

            if (l == null)
                continue;

            for (Integer i : l) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void init(){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        inDegree = new int[n + 1];
        linkedListArray = new LinkedList[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (linkedListArray[a] == null)
                linkedListArray[a] = new LinkedList<>();

            linkedListArray[a].add(b);
            inDegree[b]++;
        }
    }
}
