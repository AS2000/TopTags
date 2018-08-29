package com.vcs.toptags.counting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountWords {
    public Map<String, Integer> getCountedWordsArray(List<String> pureTextList) {

        return countWords(pureTextList);
    }

    private Map<String, Integer> countWords(List<String> pureTextList) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < pureTextList.size(); i++) {

            if (map.containsKey(pureTextList.get(i))) {
                map.put(pureTextList.get(i), map.get(pureTextList.get(i)) + 1);
            } else {
                map.put(pureTextList.get(i), 1);
            }
        }

        return map;
    }

}
