package com.example.demo;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String s, int N) {
        int answer = -1;

        for(int i = 0; i < s.length() - N + 1; i++){
            String temp = s.substring(i, i + N);

            Set<Integer> tempSet = new HashSet<>();

            for(char item : temp.toCharArray()){
                tempSet.add(item - '0');
            }

            int max = tempSet.stream().mapToInt(x -> x).max().getAsInt();

            if(max == N && tempSet.size() == N && answer < Integer.parseInt(temp))
                answer = Integer.parseInt(temp);
        }

        return answer;
    }
}