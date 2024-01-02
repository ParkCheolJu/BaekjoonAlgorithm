package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestPartialPermutation {
    static int temp[], item[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        temp = new int[size];
        item = new int[size];

        for (int i = 0; i < size; i++) {
            item[i] = sc.nextInt();
        }

        temp[0] = item[0];

        for (int i = 1; i < size; i++) {
            temp[i] = item[i];
            for (int j = 0; j < i; j++) {
                if (item[i] > item[j]) {
                    temp[i] = Math.max(temp[j] + item[i], temp[i]);
                }
            }
        }

        System.out.println(Arrays.stream(temp).max().getAsInt());
    }
}
