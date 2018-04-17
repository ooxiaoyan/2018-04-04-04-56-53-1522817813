package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class FizzBuzzGame {
    private List<String> results = new ArrayList<>();
    private String[] specialStrs = {"Fizz", "Buzz", "Whizz"};
    private int[] specialNums = {3,5,7};
    private TreeMap<Integer, String> specialMap = new TreeMap<>();

    public void setSpecialMap(int[] key, String[] value) {
        for (int i = 0; i < key.length; i++) {
            specialMap.put(key[i], value[i]);
        }
    }

    public void start(int count) {
        setSpecialMap(specialNums, specialStrs);
        String result;
        for (int i = 1; i <= count; i++) {
            result = theFifthRule(i, specialMap.firstKey(), specialMap.firstEntry().getValue());
            if (!String.valueOf(i).equals(result)) {
                results.add(result);
                continue;
            } else {
                result = theThirdAndFourthRule(i, specialMap);
            }
            results.add(result);
        }
    }

    public List<String> getResults() {
        return results;
    }

    public String theFifthRule(int num, int firstSpecialNum, String firstSpecialString) {
        String result = String.valueOf(num);
        String[] numArray = String.valueOf(num).split("");
        for (String s : numArray) {
            if (String.valueOf(firstSpecialNum).contains(s)) {
                result = firstSpecialString;
                break;
            }
        }
        return result;
    }

    public String theThirdAndFourthRule(int num, Map<Integer, String> map) {
        String result = "";
        boolean flag = true;
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            if (num % entry.getKey() == 0) {
                result = result.concat(entry.getValue());
                flag = false;
            }
        }
        if (flag) {
            return String.valueOf(num);
        } else {
            return result;
        }
    }
}


