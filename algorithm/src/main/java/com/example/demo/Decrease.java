package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decrease {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n <= 10){
            System.out.println(n);
            return;
        }

        for(long i = 0L; i < 10; i++){
            calculator(i);
        }

        Collections.sort(list);
        System.out.println(list.size() > n ? list.get(n) : "-1");
    }

    public static void calculator(long num){
        if(num > 9876543210L) return;

        list.add(num);
        System.out.println(num);

        for(int i = 0; i < 10; i++){
            if(num % 10 > i){
                calculator(num * 10 + i);
            }
        }
    }

}

