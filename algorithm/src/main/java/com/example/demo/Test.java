package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> testMap = new HashMap<>();

        testMap.put(4, 3);
        testMap.put(1, 3);
        testMap.put(2, 3);

        for(Integer key : testMap.keySet()){
            System.out.print("hashCode : " + key.hashCode() + " / key : " );
            System.out.println(key);
        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("tomato", "tomato");
        hashMap.put("apple", "apple");
        hashMap.put("banana", "banana");



        for(String key : hashMap.keySet()){
            System.out.print("hashCode : " + key.hashCode() + " / key : " );
            System.out.println(key);
        }
    }
}
