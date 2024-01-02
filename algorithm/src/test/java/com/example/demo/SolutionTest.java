package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.*;

class SolutionTest {

    public static final int MAX_SCORE = 10;
    List<Integer> scorekeySetList;

    @Test
    void solution() {
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};

        Map<Integer, Float> score = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            score.put(MAX_SCORE - i,  info[i] + 1f);
        }

        scorekeySetList = new ArrayList<>(score.keySet());

        scorekeySetList.sort(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        float ratio1 = o1 / score.get(o1);
                        float ratio2 = o2 / score.get(o2);

                        int result = Float.compare(ratio2, ratio1);
                        return result == 0 ? o2.compareTo(o1) : result;
                    }
                }
        );

        for(Map.Entry<Integer, Float> item : score.entrySet()){
            System.out.println(item.getKey() + " / " + item.getValue());
        }
        System.out.println();

        for(int item : scorekeySetList){
            System.out.println(item + " / " + score.get(item) + " / " + (item / score.get(item)));
        }
    }



}